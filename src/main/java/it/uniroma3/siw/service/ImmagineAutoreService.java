package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.ImmagineAutore;
import it.uniroma3.siw.repository.ImmagineAutoreRepository;

@Service
public class ImmagineAutoreService {

	@Autowired
    private ImmagineAutoreRepository immagineAutoreRepository;

    public ImmagineAutore save(ImmagineAutore immagine) {
        return immagineAutoreRepository.save(immagine);
    }

    public ImmagineAutore getImmagineAutoreById(Long id) {
        return immagineAutoreRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        immagineAutoreRepository.deleteById(id);
    }
    
    public List<ImmagineAutore> getAllImmaginiAutori(){
		return (List<ImmagineAutore>) this.immagineAutoreRepository.findAll();
	}
}
