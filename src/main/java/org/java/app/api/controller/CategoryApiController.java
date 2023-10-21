package org.java.app.api.controller;

import java.util.List;

import org.java.app.db.pojo.Category;
import org.java.app.db.serv.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategoryApiController {

	@Autowired
	private CategoryService categoryService;
	
	
	// Index
	@GetMapping
	public ResponseEntity<List<Category>> getAll() {
		
		List<Category> categories = categoryService.findAll();
		
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
}
