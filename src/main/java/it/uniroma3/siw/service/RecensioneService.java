package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Libro;
import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.repository.RecensioneRepository;

@Service
public class RecensioneService {
	
	@Autowired
	private RecensioneRepository recensioneRepository;
	
	public Recensione getRecensioneById(Long id) {
		return this.recensioneRepository.findById(id).orElse(null);
	}
	
	public List<Recensione> getAllRecensioni(){
		return (List<Recensione>)this.recensioneRepository.findAll();
	}
	
	public Recensione save(Recensione recensione) {
		return this.recensioneRepository.save(recensione);
	}
	
	public List<Recensione> getByAutore(User autore) {
	    return recensioneRepository.findByAutore(autore);
	}

	public void deleteById(Long id) {
		recensioneRepository.deleteById(id);
	}
	
	public boolean existsByLibroAndAutore(Libro libro, User autore) {
	    return recensioneRepository.existsByLibroAndAutore(libro, autore);
	}
}
