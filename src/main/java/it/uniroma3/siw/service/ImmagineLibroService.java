package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.ImmagineLibro;
import it.uniroma3.siw.repository.ImmagineLibroRepository;

@Service
public class ImmagineLibroService {

	@Autowired
    private ImmagineLibroRepository immagineLibroRepository;

    public ImmagineLibro save(ImmagineLibro immagine) {
        return immagineLibroRepository.save(immagine);
    }

    public ImmagineLibro getImmagineLibroById(Long id) {
        return immagineLibroRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        immagineLibroRepository.deleteById(id);
    }
    
    public List<ImmagineLibro> getAllImmaginiLibri(){
		return (List<ImmagineLibro>) this.immagineLibroRepository.findAll();
	}
}
