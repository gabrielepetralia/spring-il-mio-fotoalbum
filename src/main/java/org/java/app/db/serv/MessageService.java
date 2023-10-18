package org.java.app.db.serv;

import java.util.List;
import java.util.Optional;

import org.java.app.db.pojo.Message;
import org.java.app.db.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepo messageRepo;
	
	public void save(Message message) {
		messageRepo.save(message);
	}
	
	public List<Message> findAll() {
		return messageRepo.findAll();
	}
	
	public Optional<Message> findById(int id) {
		return messageRepo.findById(id);
	}
	
	public void delete(Message message) {
		messageRepo.delete(message);
	}
	
}
