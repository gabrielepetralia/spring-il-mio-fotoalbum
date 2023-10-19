package org.java.app.api.controller;

import org.java.app.api.dto.MessageDTO;
import org.java.app.db.pojo.Message;
import org.java.app.db.serv.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/messages")
public class MessageApiController {
	
	@Autowired
	private MessageService messageService;
	
	@PostMapping
	public ResponseEntity<Message> createMessage(
			@RequestBody MessageDTO messageDTO
		) {
		
		Message message = new Message(messageDTO);
		messageService.save(message);
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
