package it.uniroma3.siw.controller.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import it.uniroma3.siw.model.ImmagineLibro;
import it.uniroma3.siw.service.ImmagineLibroService;

@RestController
@RequestMapping("/images-db-libro")
public class ImmagineLibroController {

    private final ImmagineLibroService immagineLibroService;

    public ImmagineLibroController(ImmagineLibroService immagineLibroService) {
        this.immagineLibroService = immagineLibroService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> serveImage(@PathVariable Long id) {
        ImmagineLibro img = immagineLibroService.getImmagineLibroById(id);
        if (img == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(img.getContentType()))
                .body(img.getContent());
    }
}
