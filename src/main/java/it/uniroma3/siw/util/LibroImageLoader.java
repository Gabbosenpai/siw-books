package it.uniroma3.siw.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.model.ImmagineLibro;
import it.uniroma3.siw.model.Libro;
import it.uniroma3.siw.repository.ImmagineLibroRepository;
import it.uniroma3.siw.service.LibroService;

@Component
public class LibroImageLoader implements CommandLineRunner {

    @Autowired
    private ImmagineLibroRepository immagineLibroRepo;

    @Autowired
    private LibroService libroService;

    @Override
    public void run(String... args) throws Exception {
        if (immagineLibroRepo.count() == 0) {
            System.out.println("Carico immagini libri perché il DB è vuoto...");

            String basePath = "D:\\Programmazione\\Spring Boot Tool Suite\\Nuovo Workspace SIW\\siw-books\\src\\main\\resources\\static\\images\\books\\";
            
            try (Stream<Path> paths = Files.list(Paths.get(basePath))) {
                List<Path> fileList = paths
                        .filter(Files::isRegularFile)
                        .collect(Collectors.toList());
                
                List<Libro> tuttiLibri = libroService.getAllLibri();

                for (Path filePath : fileList) {
                    String fileName = filePath.getFileName().toString();
                    
                    // Rimuovo estensione
                    String fileNameNoExt = fileName.substring(0, fileName.lastIndexOf('.'));
                    
                    // Trovo indice dell'ultimo trattino (prima del numero)
                    int lastDash = fileNameNoExt.lastIndexOf("-");
                    if (lastDash == -1) {
                        System.out.println("Filename non in formato corretto: " + fileName);
                        continue;
                    }

                    // Es. "Kafka-on-the-Shore-0" → "Kafka on the Shore"
                    String titoloNormalizzato = fileNameNoExt.substring(0, lastDash)
                            .replace("-", " ")
                            .trim();

                    Libro libroMatch = null;
                    for (Libro libro : tuttiLibri) {
                        if (libro.getTitle() != null &&
                            libro.getTitle().trim().equalsIgnoreCase(titoloNormalizzato)) {
                            libroMatch = libro;
                            break;
                        }
                    }
                    
                    if (libroMatch == null) {
                        System.out.println("Nessun libro trovato per titolo: " + titoloNormalizzato);
                        continue;
                    }
                    
                    byte[] bytes = Files.readAllBytes(filePath);
                    
                    ImmagineLibro img = new ImmagineLibro();
                    img.setFileName(fileName);
                    img.setContentType("image/jpeg");
                    img.setContent(bytes);
                    img.setLibro(libroMatch);
                    
                    libroMatch.addImmagine(img);
                    
                    immagineLibroRepo.save(img);
                    System.out.println("Salvata immagine: " + fileName + " per libro: " + libroMatch.getTitle());
                }
                
            }
            System.out.println("Caricamento immagini libri completato!");
        } else {
            System.out.println("Immagini libri già presenti. Skip caricamento.");
        }
    }
}
