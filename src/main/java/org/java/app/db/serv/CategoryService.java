package org.java.app.db.serv;

import java.util.List;
import java.util.Optional;

import org.java.app.db.pojo.Category;
import org.java.app.db.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	public void save(Category category) {
		categoryRepo.save(category);
	}
	
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}
	
	public Optional<Category> findById(int id) {
		return categoryRepo.findById(id);
	}
	
	public void delete(Category category) {
		categoryRepo.delete(category);
	}
	
}
