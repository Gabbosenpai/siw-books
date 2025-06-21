package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Recensione;
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
	
}
