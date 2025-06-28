package it.uniroma3.siw.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.model.ImmagineAutore;
import it.uniroma3.siw.repository.ImmagineAutoreRepository;

@Component
public class ImageLoader implements CommandLineRunner{

	@Autowired
	private ImmagineAutoreRepository immagineRepo;

	@Override
	public void run(String... args) throws Exception {
		if (immagineRepo.count() == 0) {
			System.out.println("Carico immagini perché il DB è vuoto...");

			// lista dei fileName
			List<String> fileNames = List.of(
					"George_Orwell.jpg",
					"Haruki_Murakami.jpg",
					"Jane_Austen.jpg",
					"Fyodor_Dostoevsky.jpg",
					"J_K_Rowling.jpg",
					"Gabriel_Garcia_Marquez.jpg",
					"Stephen_King.jpg",
					"Margaret_Atwood.jpg",
					"Umberto_Eco.jpg",
					"Chimamanda_Ngozi_Adichie.jpg",
					"Lev_Tolstoy.jpg",
					"Franz_Kafka.jpg",
					"Italo_Calvino.jpg",
					"Isabel_Allende.jpg",
					"Albert_Camus.jpg"
					);

			String basePath = "D:\\Programmazione\\Spring Boot Tool Suite\\Nuovo Workspace SIW\\siw-books\\src\\main\\resources\\static\\images\\writers\\";

			for (String fileName : fileNames) {
				Path path = Paths.get(basePath + fileName);
				byte[] bytes = Files.readAllBytes(path);

				ImmagineAutore img = new ImmagineAutore();
				img.setFileName(fileName);
				img.setContentType("image/jpeg"); // tutte JPG
				img.setContent(bytes);

				immagineRepo.save(img);
				System.out.println("Salvata immagine: " + fileName);
			}
			System.out.println("Caricamento immagini completato!");
	    } else {
	        System.out.println("Immagini già presenti. Skip caricamento.");
	    }
	}
}