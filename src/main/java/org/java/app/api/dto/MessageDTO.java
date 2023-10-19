package org.java.app.api.dto;

public class MessageDTO {

	private String email;
	private String msgText;
	
	public MessageDTO() {};
	
	public MessageDTO(String email, String msgText) {
		setEmail("email");
		setMsgText("msgText");
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
