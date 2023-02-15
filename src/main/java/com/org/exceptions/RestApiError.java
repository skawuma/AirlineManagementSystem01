package com.org.exceptions;
import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
public class RestApiError implements Serializable {
    
    private static final long serialVersionUID = 2615822728170007835L;
	private HttpStatus status;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private String path;

	/**
	 * 
	 */
	public RestApiError() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param status
	 * @param timestamp
	 * @param message
	 * @param path
	 */
	public RestApiError(HttpStatus status, LocalDateTime timestamp, String message, String path) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.message = message;
		this.path = path;
	}

	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "RestApiError [status=" + status + ", timestamp=" + timestamp + ", message=" + message + ", path=" + path
				+ "]";
	}



}
