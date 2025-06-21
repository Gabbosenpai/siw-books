package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.service.AutoreService;

@Controller
public class AutoreController {

	@Autowired
	private AutoreService autoreService;
	
	@GetMapping("/autore")
	public String showAutori(Model model) {
		model.addAttribute("autori", this.autoreService.getAllAutori());
		return "autori.html";
	}
	
	@GetMapping("/autore/{id}")
	public String getAutore(@PathVariable("id") Long id, Model model) {
		Autore autore = this.autoreService.getAutoreById(id);
		if(autore == null) {
			return "autoreNotFound.html";
		}
		model.addAttribute("autore", autore);
		return "autore.html";
	}
}
