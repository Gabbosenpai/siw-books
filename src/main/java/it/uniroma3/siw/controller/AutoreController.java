package it.uniroma3.siw.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.ImmagineAutore;
import it.uniroma3.siw.model.Libro;
import it.uniroma3.siw.model.Nationality;
import it.uniroma3.siw.service.AutoreService;
import it.uniroma3.siw.service.CredentialsService;
import it.uniroma3.siw.service.LibroService;
import jakarta.validation.Valid;

@Controller
public class AutoreController {

	@Autowired
	private AutoreService autoreService;
	@Autowired
	private LibroService libroService;
	@Autowired
	private CredentialsService credentialsService;
	
	@GetMapping("/autore")
	public String showAutori(Model model, Principal principal) {
		
		if (principal != null) {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
			model.addAttribute("role", credentials.getRole());
		}
		model.addAttribute("autori", this.autoreService.getAllAutori());
		return "autori.html";
	}
	
	@GetMapping("/autore/{id}")
	public String getAutore(@PathVariable("id") Long id, Model model, Principal principal) {
		Autore autore = this.autoreService.getAutoreById(id);
		if(autore == null) {
			return "notFound.html";
		}
		if (principal != null) {
			UserDetails userDetailsRole = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Credentials credentials = credentialsService.getCredentials(userDetailsRole.getUsername());
			model.addAttribute("role", credentials.getRole());
		}
		model.addAttribute("autore", autore);
		return "autore.html";
	}
	
	@GetMapping("/autore/formNewAutore")
	public String formNewAutore(Model model, Principal principal) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
		model.addAttribute("role", credentials.getRole());
		if (!credentials.getRole().equals("ADMIN")) {
			return "notFound.html";
		}
		if(!model.containsAttribute("autore")) {
			model.addAttribute("autore",new Autore());
		}
		model.addAttribute("nationalities", Nationality.values());
		return "formNewAutore.html";
	}

	@PostMapping("/autore/newAutore")
	public String newAutore(@Valid @ModelAttribute("autore") Autore autore, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model, @RequestParam("immagineFile") MultipartFile immagineFile) {
		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.autore", bindingResult);
			redirectAttributes.addFlashAttribute("autore", autore);
			return "redirect:/autore/formNewAutore";
		}
		if (!immagineFile.isEmpty()) {
	        try {
	            ImmagineAutore immagine = new ImmagineAutore();
	            immagine.setContent(immagineFile.getBytes());
	            immagine.setContentType(immagineFile.getContentType());
	            immagine.setFileName(immagineFile.getOriginalFilename());

	            // associa l'immagine all'autore (gestisce anche la relazione bidirezionale)
	            autore.setImmagine(immagine);

	        } catch (IOException e) {
	            e.printStackTrace();
	            redirectAttributes.addFlashAttribute("uploadError", "Errore durante il caricamento dell'immagine");
	            redirectAttributes.addFlashAttribute("autore", autore);
	            return "redirect:/autore/formNewAutore";
	        }
	    }

	    this.autoreService.save(autore);
	    return "redirect:/autore/" + autore.getId();
	}
	
	@PostMapping("/autore/{id}/delete")
	public String deleteAutore(@PathVariable Long id) {
	    Autore autore = autoreService.getAutoreById(id);
	    if (autore != null) {
	        for (Libro libro : new ArrayList<>(autore.getListaLibri())) {
	            libro.removeAutore(autore);
	        }
	        autoreService.deleteAutoreById(id);
	    }
	    return "redirect:/autore";
	}
	
	@GetMapping("/autore/{id}/edit")
	public String formEditAutore(@PathVariable("id") Long id, Model model, Principal principal) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
		model.addAttribute("role", credentials.getRole());
		if (!credentials.getRole().equals("ADMIN")) {
			return "notFound.html";
		}
		Autore autore = autoreService.getAutoreById(id);
		List<Libro> listaLibri = libroService.getAllLibri();

		model.addAttribute("autore", autore);
		model.addAttribute("listaLibri", listaLibri);
		model.addAttribute("nationalities", Nationality.values());

		return "formEditAutore.html";
	}
	
	@PostMapping("/autore/{id}/edit")
	public String editAutore(@PathVariable("id") Long id,
	                         @ModelAttribute("autore") Autore autoreAggiornato,
	                         @RequestParam(value = "libriDaRimuovere", required = false) List<Long> libriDaRimuovere,
	                         @RequestParam(value = "libriDaAggiungere", required = false) List<Long> libriDaAggiungere,
	                         Model model, Principal principal) {

	    // Controllo di sicurezza
	    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
	    if (!"ADMIN".equals(credentials.getRole())) {
	        return "notFound.html";
	    }

	    // Recupera l'autore dal DB
	    Autore autore = autoreService.getAutoreById(id);
	    if (autore == null) {
	        return "notFound.html";
	    }

	    // Aggiorna i campi semplici
	    autore.setFirstName(autoreAggiornato.getFirstName());
	    autore.setLastName(autoreAggiornato.getLastName());
	    autore.setDateOfBirth(autoreAggiornato.getDateOfBirth());
	    autore.setDateOfDeath(autoreAggiornato.getDateOfDeath());
	    autore.setNationality(autoreAggiornato.getNationality());

	    // Rimuovi libri selezionati (se ce ne sono)
	    if (libriDaRimuovere != null) {
	        for (Long libroId : libriDaRimuovere) {
	            Libro libro = libroService.getLibroById(libroId);
	            if (libro != null) {
	                autore.removeLibro(libro);
	            }
	        }
	    }

	    // Aggiungi libri selezionati (se ce ne sono)
	    if (libriDaAggiungere != null) {
	        for (Long libroId : libriDaAggiungere) {
	            Libro libro = libroService.getLibroById(libroId);
	            if (libro != null && !autore.getListaLibri().contains(libro)) {
	                autore.addLibro(libro);
	            }
	        }
	    }

	    // Salva l'autore aggiornato
	    autoreService.save(autore);

	    // Redirect alla pagina dell'autore aggiornato
	    return "redirect:/autore/" + autore.getId();
	}

}

