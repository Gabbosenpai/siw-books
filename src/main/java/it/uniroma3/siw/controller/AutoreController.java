package it.uniroma3.siw.controller;

import java.io.IOException;
import java.security.Principal;

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
import it.uniroma3.siw.model.Nationality;
import it.uniroma3.siw.service.AutoreService;
import it.uniroma3.siw.service.CredentialsService;
import jakarta.validation.Valid;

@Controller
public class AutoreController {

	@Autowired
	private AutoreService autoreService;
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
	public String getAutore(@PathVariable("id") Long id, Model model) {
		Autore autore = this.autoreService.getAutoreById(id);
		if(autore == null) {
			return "notFound.html";
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
}
