package com.matteoroxis.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;

public class ExceptionResponse {
	
	private LocalDate timestamp;
	private String message;
	private String detail;
	public ExceptionResponse(LocalDate timestamp, String message, String detail) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detail = detail;
	}
	public LocalDate getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	

}
