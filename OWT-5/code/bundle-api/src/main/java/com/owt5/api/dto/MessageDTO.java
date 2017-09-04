package com.owt5.api.dto;

/**
 * 
 * MessageDTO
 *
 */
public class MessageDTO {
	
	private String message;
	private String when;
	
	public MessageDTO(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getWhen() {
		return when;
	}
	public void setWhen(String when) {
		this.when = when;
	}

}
