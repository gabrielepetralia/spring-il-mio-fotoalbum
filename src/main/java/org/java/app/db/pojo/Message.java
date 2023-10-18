package org.java.app.db.pojo;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	@Email(message = "Inserire un indirizzo email valido")
	@NotBlank(message = "Inserire l'indirizzo email")
	@Length(max = 255, message = "Il nome deve avere un minimo di 3 e un massimo di 30 caratteri")
	private String email;
	
	@NotBlank(message = "Inserire un messaggio")
	@Length(max = 255, message = "La descrizione deve avere un massimo di 255 caratteri")
	private String msgText;
	
	public Message(String email, String msgText) {
		setEmail("email");
		setMsgText("msgText");
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMsgText() {
		return msgText;
	}
	
	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}
	
}
