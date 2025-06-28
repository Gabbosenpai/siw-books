package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"firstName","lastName", "dateOfBirth"}))
public class Autore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private LocalDate dateOfBirth;
	
	@Column(nullable = true)
	private LocalDate dateOfDeath;
	
	@Enumerated(EnumType.STRING)
	private Nationality nationality;//forse si può gestire meglio
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private ImmagineAutore immagine;
	
	@ManyToMany(mappedBy="listaAutori", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch= FetchType.EAGER) 
	private List<Libro> listaLibri = new ArrayList<>();
	
	public Autore() {}
	
	public Autore(String firstName, String lastName, LocalDate dateOfBirth, LocalDate dateOfDeath, Nationality nationality) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfDeath = dateOfDeath;
		this.nationality = nationality;
	}
	
	public void addLibro(Libro libro) {
	    if (libro != null && !listaLibri.contains(libro)) {
	        listaLibri.add(libro);
	        libro.getListaAutori().add(this);
	    }
	}

	public void removeLibro(Libro libro) {
	    if (libro != null && listaLibri.remove(libro)) {
	        libro.getListaAutori().remove(this);
	    }
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(LocalDate dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public Nationality getNationality() {
		return nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}
	
	public ImmagineAutore getImmagine() {
	    return immagine;
	}

	public void setImmagine(ImmagineAutore immagine) {
	    if (this.immagine != null) {
	        this.immagine.setAutore(null);
	    }
	    this.immagine = immagine;
	    if (immagine != null) {
	        immagine.setAutore(this);
	    }
	}

	public List<Libro> getListaLibri() {
		return listaLibri;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOfBirth, firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autore other = (Autore) obj;
		return Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName);
	}
	
	
}
