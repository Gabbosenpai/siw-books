package it.uniroma3.siw.controller.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.siw.model.ImmagineAutore;
import it.uniroma3.siw.service.ImmagineAutoreService;

@RestController
@RequestMapping("/images-db")
public class ImmagineAutoreController {

    private final ImmagineAutoreService immagineAutoreService;

    public ImmagineAutoreController(ImmagineAutoreService immagineAutoreService) {
        this.immagineAutoreService = immagineAutoreService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> serveImage(@PathVariable Long id) {
        ImmagineAutore img = immagineAutoreService.getImmagineAutoreById(id);
        if (img == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(img.getContentType()))
                .body(img.getContent());
    }
}
