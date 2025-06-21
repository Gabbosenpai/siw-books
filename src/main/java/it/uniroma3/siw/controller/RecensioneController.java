package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.service.RecensioneService;

@Controller
public class RecensioneController {
    
	@Autowired
	private RecensioneService recensioneService;
	
	@GetMapping("/recensione")
	public String showRecensioni(Model model) {
		model.addAttribute("recensioni", this.recensioneService.getAllRecensioni());
		return "recensioni.html";
	}
	
	@GetMapping("/recensione/{id}")
	public String getRecensione(@PathVariable("id") long id, Model model) {
		Recensione recensione =this.recensioneService.getRecensioneById(id);
		if(recensione == null) {
			return "recensioneNotFound.html";
		}
		model.addAttribute("recensione", recensione);
		return "recensione.html";
	}
}
