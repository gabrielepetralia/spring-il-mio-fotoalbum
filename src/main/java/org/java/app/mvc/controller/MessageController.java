package org.java.app.mvc.controller;

import java.util.List;
import java.util.Optional;

import org.java.app.db.pojo.Message;
import org.java.app.db.serv.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/messages")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	
	// Index
	@GetMapping
	public String getIndex(Model model, @RequestParam(required = false) String email) {
		
		List<Message> messages = email == null 
					? messageService.findAll()
					: messageService.findByEmail(email);
		
		model.addAttribute("messages", messages);
		model.addAttribute("email", email); // togliere (?)
		
		return "message-index";
	}
	
	// Show
	@GetMapping("/{id}")
	public String getShow(@PathVariable int id, Model model) {
		
		Optional<Message> message = messageService.findById(id);
		
		if (message.isEmpty()) return "message-index";

		model.addAttribute("message", message);
		
		return "message-show";
	}
	
	// Delete
	@PostMapping("/delete/{id}")
	public String deleteMessage(@PathVariable int id) {
		
		Optional<Message> optMessage = messageService.findById(id);
		
		if (optMessage.isEmpty()) return "message-index";
		
		Message message = optMessage.get();
		
		messageService.delete(message);
		
		return "redirect:/messages";
	}
	
}
