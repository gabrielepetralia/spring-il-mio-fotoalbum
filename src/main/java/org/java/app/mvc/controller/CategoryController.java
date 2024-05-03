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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PhotoService photoService;
	
	
	// Index
	@GetMapping
	public String getIndex(HttpServletRequest request, Model model) {
		String servletPath = request.getServletPath();
		
		List<Category> categories = categoryService.findAll();
		
		model.addAttribute("categories", categories);
		model.addAttribute("servletPath", servletPath);
		
		// create
		model.addAttribute("category", new Category());
		
		return "category-index";
	}
	
	// Create
//	@GetMapping("/create")
//	public String getCreateForm(Model model) {
//		
//		model.addAttribute("category", new Category());
//		
//		return "category-create";
//	}
	
	@PostMapping("/create")
	public String storeCategory(
			@Valid @ModelAttribute Category category,
			BindingResult bindingResult,
			Model model
			) {

		if (bindingResult.hasErrors()) {

			System.out.println("Error: ");
			bindingResult.getAllErrors().stream()
					.map(e -> e.getDefaultMessage())
				.forEach(System.out::println);

			return "category-create";
		}

		try {
			categoryService.save(category);
		} catch (DataIntegrityViolationException e) {

			// CONSTRAIN VALIDATION (unique)
			System.out.println("Errore constrain: " + e.getClass().getSimpleName());

			model.addAttribute("nameUnique", "Nome già presente");

			return "category-create";
		}

		return "redirect:/categories";
	}
	
	// Delete
	@PostMapping("/delete/{id}")
	public String deleteCategory(@PathVariable int id) {
		
		Optional<Category> optCategory = categoryService.findById(id);
		
		if (optCategory.isEmpty()) return "category-index";
		
		Category category = optCategory.get();
		
		for (Photo photo : category.getPhotos()) {
            photo.getCategories().remove(category);
            photoService.save(photo);
        }
		
		categoryService.delete(category);
		
		return "redirect:/categories";
	}
	
}
