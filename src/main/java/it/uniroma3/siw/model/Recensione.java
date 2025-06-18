package it.uniroma3.siw.model;

import java.util.Objects;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class Recensione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	@Min(1)
	@Max(5)
	private Integer rating;

	public Recensione() {
		
	}
	
	public Recensione(String title, String description, Integer rating) {
		this.title = title;
		this.description = description;
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

	public String getDescroption() {
		return description;
	}

	public void setDescroption(String descroption) {
		this.description = descroption;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, rating, title);
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
		return Objects.equals(description, other.description) && Objects.equals(rating, other.rating)
				&& Objects.equals(title, other.title);
	}
	
	
}