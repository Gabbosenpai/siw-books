package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.repository.AutoreRepository;

@Service
public class AutoreService {

	@Autowired
	private AutoreRepository autoreRepository;
	
	public Autore getAutoreById(Long id) {
		return this.autoreRepository.findById(id).orElse(null);
	}
	
	public List<Autore> getAllAutori(){
		return (List<Autore>)this.autoreRepository.findAll();
	}
}
