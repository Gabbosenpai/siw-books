package it.uniroma3.siw.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.uniroma3.siw.model.ImmagineLibro;
import it.uniroma3.siw.model.Libro;
import it.uniroma3.siw.model.Recensione;
import it.uniroma3.siw.service.LibroService;

@Controller
public class LibroController {

	@Autowired
	private LibroService libroService;
	
	@GetMapping("/libro")
	public String showLibri(Model model) {
		List<Libro> libri = (List<Libro>)this.libroService.getAllLibri();
		model.addAttribute("libri", libri);
		return "libri.html";
	}
	
	@GetMapping("/libro/{id}")
	public String getLibro(@PathVariable("id") Long id, Model model) { 
		Libro libro = this.libroService.getLibroById(id);
		if(libro == null) {
			return "notFound.html";
		}
		List <Recensione> reversed = libro.getListaRecensioni();
		Collections.reverse(reversed);
		libro.setListaRecensioni(reversed);
		model.addAttribute("libro", libro);
		return "libro.html";
	}
	
}
