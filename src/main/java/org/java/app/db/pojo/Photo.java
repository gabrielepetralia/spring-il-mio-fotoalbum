package org.java.app.db.pojo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, unique = true)
	@Length(min = 3, max = 30, message = "Il titolo deve avere un minimo di 3 e un massimo di 30 caratteri")
	private String title;
	
	@Length(max = 255, message = "La descrizione deve avere un massimo di 255 caratteri")
	private String description;
	
	@Column(nullable = false)
	@Length(max = 255, message = "L\' url deve avere un massimo di 255 caratteri")
	@NotBlank(message = "Inserire l\' url dell\' immagine")
	private String url;
	
	@Column(nullable = false)
	@NotNull
	private Boolean visible;
	
	@ManyToMany
	@JsonManagedReference
	private List<Category> categories;
	
	public Photo() {};
	
	public Photo(String title, String description, String url, Boolean visible, Category...categories) {
		setTitle(title);
		setDescription(description);
		setUrl(url);
		setVisible(visible);
		setCategories(Arrays.asList(categories));
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Boolean getVisible() {
		return visible;
	}
	
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	
	public List<Category> getCategories() {
		return categories;
	}
	
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}	
