package it.uniroma3.siw.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.Libro;
import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.service.AutoreService;
import it.uniroma3.siw.service.CredentialsService;
import it.uniroma3.siw.service.LibroService;
import it.uniroma3.siw.service.RecensioneService;
import jakarta.validation.Valid;

@Controller
public class LibroController {

	@Autowired
	private LibroService libroService;
	
	@Autowired
	private CredentialsService credentialsService;
	
	@Autowired
	private RecensioneService recensioneService;
	
	@Autowired
	private AutoreService autoreService;
	
	@GetMapping("/libro")
	public String showLibri(Model model, Principal principal) {
		List<Libro> libri = (List<Libro>)this.libroService.getAllLibri();
		
		if (principal != null) {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
			model.addAttribute("role", credentials.getRole());
		}
		model.addAttribute("libri", libri);
		return "libri.html";
	}
	
	@GetMapping("/libro/{id}")
	public String getLibro(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal UserDetails userDetails) { 
		Libro libro = this.libroService.getLibroById(id);
		if(libro == null) {
			return "notFound.html";
		}
		List <Recensione> reversed = libro.getListaRecensioni();
		Collections.reverse(reversed);
		libro.setListaRecensioni(reversed);
		model.addAttribute("libro", libro);
		boolean haGiaRecensito = false;

		if (userDetails != null) {
			String username = userDetails.getUsername();
			for (Recensione rec : libro.getListaRecensioni()) {
				if (rec.getAutore() != null && rec.getAutore().getCredentials().getUsername().equals(username)) {
					haGiaRecensito = true;
					break; // esci appena trovi una corrispondenza
				}
			}
		}
		model.addAttribute("haGiaRecensito", haGiaRecensito);
		return "libro.html";
	}
	
	@GetMapping("/libro/{id}/formNewRecensione")
	public String formNewRecensione(@PathVariable("id") Long id , Model model) {
		Libro libro = this.libroService.getLibroById(id);
		if(libro==null) { 
			return "notFound.html"; //aggiungere errore
		}
		if(!model.containsAttribute("recensione")) {
			model.addAttribute("libro", libro);
			model.addAttribute("recensione",new Recensione());
		}
		return "formNewRecensione.html";
	}
	
	@PostMapping("/libro/{id}/recensione")
	public String addRecensione(@PathVariable("id") Long id,
	                            @Valid @ModelAttribute("recensione") Recensione recensione,
	                            BindingResult bindingResult,
	                            RedirectAttributes redirectAttributes,
	                            Model model,
	                            @AuthenticationPrincipal UserDetails userDetails) {

	    Libro libro = this.libroService.getLibroById(id);
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();

	    Credentials credentials = this.credentialsService.getCredentials(username);
	    User autore = credentials.getUser();

	    if (bindingResult.hasErrors()) {
	        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.recensione", bindingResult);
	        redirectAttributes.addFlashAttribute("recensione", recensione);
	        redirectAttributes.addFlashAttribute("libro", libro);
	        return "redirect:/libro/" + libro.getId() + "/formNewRecensione";
	    }
	    model.addAttribute("libro", libro);
	    if (this.recensioneService.existsByLibroAndAutore(libro, autore)) {
	        model.addAttribute("errorMessage", "Hai già scritto una recensione per questo libro!");
	        return "formNewRecensione.html";
	    }

	    recensione.setId(null);
	    recensione.setLibro(libro);
	    recensione.setAutore(autore); 
	    this.recensioneService.save(recensione);

	    return "redirect:/libro/" + libro.getId();
	}
	
	@GetMapping("/libro/formNewLibro")
	public String formNewLibro(Model model, Principal principal) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
		model.addAttribute("role", credentials.getRole());
		if (!credentials.getRole().equals("ADMIN")) {
			return "notFound.html";
		}
		if(!model.containsAttribute("libro")) {
			model.addAttribute("libro",new Libro());
		}
		model.addAttribute("autori", autoreService.getAllAutori());
		return "formNewLibro.html";
	}
	
}
