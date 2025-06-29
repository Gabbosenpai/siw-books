package it.uniroma3.siw.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.service.CredentialsService;
import it.uniroma3.siw.service.RecensioneService;
import jakarta.transaction.Transactional;

@Controller
public class RecensioneController {
    
	@Autowired
	private RecensioneService recensioneService;
	@Autowired
	private CredentialsService credentialsService;
	
	@GetMapping("/recensione")
	public String showRecensioni(Model model, Principal principal) {
		model.addAttribute("recensioni", this.recensioneService.getAllRecensioni());
		if (principal != null) {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
			model.addAttribute("role", credentials.getRole());
		}
		return "recensioni.html";
	}
	
	@GetMapping("/recensione/{id}")
	public String getRecensione(@PathVariable("id") long id, Model model) {
		Recensione recensione =this.recensioneService.getRecensioneById(id);
		if(recensione == null) {
			return "notFound.html";
		}
		model.addAttribute("recensione", recensione);
		return "recensione.html";
	}
	
	@Transactional
	@GetMapping("/recensione/{username}/recensioni")
	public String recensioniUtente(@PathVariable("username") String username, Model model) {
	    Credentials credentials = this.credentialsService.getCredentials(username);
	    if (credentials == null || credentials.getUser() == null) {
	        return "notFound.html"; // inserire errore
	    }

	    User user = credentials.getUser();
	    List<Recensione> recensioni = this.recensioneService.getByAutore(user);

	    model.addAttribute("recensioni", recensioni);
	    model.addAttribute("utente", user);
	    return "recensioniUtente.html";
	}
	
	@PostMapping("/recensione/delete")
	public String eliminaRecensione(@RequestParam("id") Long id) {
		recensioneService.deleteById(id);
		return "redirect:/recensione";
	}
}
