package org.java.app.api.controller;

import java.util.List;
import java.util.Optional;

import org.java.app.db.pojo.Photo;
import org.java.app.db.serv.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/photos")
public class PhotoApiController {

	@Autowired
	private PhotoService photoService;
	
	
	// Index
	@GetMapping
	public ResponseEntity<List<Photo>> getAll(@RequestParam(required = false, name = "title") String query) {
		
		List<Photo> photos = null;
		
		if (query == null) 
			photos = photoService.findAll();
		else 
			photos = photoService.findByTitle(query);
		
		return new ResponseEntity<>(photos, HttpStatus.OK);
	}
	
	// Show
	@GetMapping("{id}")
	public ResponseEntity<Photo> getById(@PathVariable int id) {
		
		Optional<Photo> photo = photoService.findById(id);
		
		if (photo.isEmpty()) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(photo.get(), HttpStatus.OK);
	}
	
}
