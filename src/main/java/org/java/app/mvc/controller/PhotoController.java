package org.java.app.mvc.controller;

import java.util.List;
import java.util.Optional;

import org.java.app.db.pojo.Category;
import org.java.app.db.pojo.Photo;
import org.java.app.db.serv.CategoryService;
import org.java.app.db.serv.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/photos")
public class PhotoController {
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	// Index
	@GetMapping
	public String getIndex(Model model, @RequestParam(required = false) String title) {
		
		List<Photo> photos = title == null 
					? photoService.findAll()
					: photoService.findByTitle(title);
		
		model.addAttribute("photos", photos);
		model.addAttribute("name", title);
		
		return "photo-index";
	}
	
	// Show
	@GetMapping("/{id}")
	public String getShow(@PathVariable int id, Model model) {
		
		Optional<Photo> photo = photoService.findById(id);
		
		if (photo.isEmpty()) return "photo-index";

		model.addAttribute("photo", photo);
		
		return "photo-show";
	}
	
	// Create
	@GetMapping("/create")
	public String getCreateForm(Model model) {
		
		List<Category> categories = categoryService.findAll();
		
		model.addAttribute("photo", new Photo());
		model.addAttribute("categories", categories);
		
		return "photo-create-edit";
	}
	
	@PostMapping("/create")
	public String storePhoto(
			@Valid @ModelAttribute Photo photo,
			BindingResult bindingResult,
			Model model
			) {

		return savePhoto(photo, bindingResult, model);
	}
	
	// Edit
	@GetMapping("/edit/{id}")
	public String getEditForm(
			@PathVariable int id,
			Model model
		) {
		
		List<Category> categories = categoryService.findAll();
		Photo photo = photoService.findById(id).get();
		
		model.addAttribute("photo", photo);
		model.addAttribute("categories", categories);
		
		return "photo-create-edit";
	}
	
	@PostMapping("/edit/{id}")
	public String updatePhoto(
			@Valid @ModelAttribute Photo photo,
			BindingResult bindingResult,
			Model model
			) {

		return savePhoto(photo, bindingResult, model);
	}
	
	// Delete
	@PostMapping("/delete/{id}")
	public String deletePhoto(@PathVariable int id) {
		
		Optional<Photo> optPhoto = photoService.findById(id);
		
		if (optPhoto.isEmpty()) return "photo-index";
		
		Photo photo = optPhoto.get();
		
		photoService.delete(photo);
		
		return "redirect:/photos";
	}
	
	
	// Private Methods
	private String savePhoto(
			Photo photo,
			BindingResult bindingResult,
			Model model
		) {

		if (bindingResult.hasErrors()) {

			System.out.println("Error: ");
			bindingResult.getAllErrors().stream()
					.map(e -> e.getDefaultMessage())
				.forEach(System.out::println);

			return "photo-create-edit";
		}

		try {
			photoService.save(photo);
		} catch (DataIntegrityViolationException e) {

			// CONSTRAIN VALIDATION (unique)
			System.out.println("Errore constrain: " + e.getClass().getSimpleName());

			model.addAttribute("titleUnique", "Titolo già presente");

			return "photo-create-edit";
		}

		return "redirect:/photos";
	}
}
