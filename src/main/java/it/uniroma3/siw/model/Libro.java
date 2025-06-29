package it.uniroma3.siw.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"title", "year"}))
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String title; //titolo libro
	
	@Max(2025)
	@Column(nullable = false)
	private Integer year;//anno di pubblicazione
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch= FetchType.EAGER)
	private List<Autore> listaAutori = new ArrayList<>();;
	
	@OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Recensione> listaRecensioni = new ArrayList<>();;
	
	@OneToMany(mappedBy = "libro",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImmagineLibro> listaImmagini = new ArrayList<>();;
	
	public Libro() {}
	
	public Libro(String title, Integer year) {
		this.year = year;
		this.title = title;
	}
	
	public void addImmagine(ImmagineLibro immagine) {
        if (immagine != null && !listaImmagini.contains(immagine)) {
            listaImmagini.add(immagine);
            immagine.setLibro(this);
        }
    }

	public void removeImmagine(ImmagineLibro immagine) {
        if (listaImmagini.remove(immagine)) {
            immagine.setLibro(null);
        }
    }
	
    public void addAutore(Autore autore) {
        if (autore != null && !listaAutori.contains(autore)) {
            listaAutori.add(autore);
            autore.getListaLibri().add(this);
        }
    }

    public void removeAutore(Autore autore) {
        if (listaAutori.remove(autore)) {
            autore.getListaLibri().remove(this);
        }
    }
    
    public void addRecensione(Recensione recensione) {
        if (recensione != null && !listaRecensioni.contains(recensione)) {
            listaRecensioni.add(recensione);
            recensione.setLibro(this);
        }
    }

    public void removeRecensione(Recensione recensione) {
        if (listaRecensioni.remove(recensione)) {
            recensione.setLibro(null);
        }
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public List<Recensione> getListaRecensioni() {
		return listaRecensioni;
	}

	public void setListaRecensioni(List<Recensione> listaRecensioni) {
		this.listaRecensioni = listaRecensioni;
	}

	public List<Autore> getListaAutori() {
		return listaAutori;
	}

	public void setListaAutori(List<Autore> listaAutori) {
		this.listaAutori = listaAutori;
	}

	public List<ImmagineLibro> getListaImmagini() {
		return listaImmagini;
	}

	public void setListaImmagini(List<ImmagineLibro> listaImmagini) {
		this.listaImmagini = listaImmagini;
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(title, other.title) && Objects.equals(year, other.year);
	}
	
	
}
