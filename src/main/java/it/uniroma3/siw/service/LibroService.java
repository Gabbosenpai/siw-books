package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.model.Libro;
import it.uniroma3.siw.repository.LibroRepository;

@Service
public class LibroService {
	
	@Autowired
	private LibroRepository libroRepository;
	
	public Libro getLibroById(Long id) {
		return this.libroRepository.findById(id).orElse(null);
	}
	
	public List<Libro> getAllLibri(){
		return (List<Libro>)this.libroRepository.findAll();
	}
	
	public Libro save(Libro libro) {
		return this.libroRepository.save(libro);
	}
	
	public Libro getLibroByTitle(String title) {
		return this.libroRepository.findByTitle(title);
	}
}
