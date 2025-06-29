package it.uniroma3.siw.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Recensione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(length = 2000, nullable = false)
	
	private String text;
	
	@Min(1)
	@Max(5)
	@Column(nullable = false)
	private Integer rating;
	
	@ManyToOne()
	private Libro libro;
	
	@ManyToOne
    private User autore;


	public Recensione() {}
	
	public Recensione(String title, String text, Integer rating) {
		this.title = title;
		this.text = text;
		this.rating = rating;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
	    this.libro = libro;
	    if(libro != null && !libro.getListaRecensioni().contains(this)) {
	        libro.getListaRecensioni().add(this);
	    }
	}

	public User getAutore() {
		return autore;
	}

	public void setAutore(User autore) {
		this.autore = autore;
	}

	@Override
	public int hashCode() {
		return Objects.hash(text, rating, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recensione other = (Recensione) obj;
		return Objects.equals(text, other.text) && Objects.equals(rating, other.rating)
				&& Objects.equals(title, other.title);
	}
	
	
}