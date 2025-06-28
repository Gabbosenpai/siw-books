package it.uniroma3.siw.model;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class ImmagineLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob //indica a JPA che i byte possono essere grandi (BLOB). Quindi il DB non tronca i dati.
    @Column(nullable = false)
    private byte[] content;    // i byte dell'immagine

    @Column(nullable = false, length = 255)
    private String contentType; // es. "image/png", "image/jpeg"

    @Column(nullable = false, length = 255)
    private String fileName;    // nome originale del file caricato

    @ManyToOne
    private Libro libro;

    public ImmagineLibro() {
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
        if(libro != null && !libro.getListaImmagini().contains(this)) {
            libro.getListaImmagini().add(this);
        }
    }

	@Override
	public int hashCode() {
		return Objects.hash(fileName, libro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImmagineLibro other = (ImmagineLibro) obj;
		return Objects.equals(fileName, other.fileName) && Objects.equals(libro, other.libro);
	}
    
    
}
