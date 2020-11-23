package com.nuvu.customer.model;

import java.io.Serializable;

public class GeneralResponse<T> implements Serializable {

	private static final long serialVersionUID = 2975454650689834772L;

	private T data;
	private boolean success;
	private String message;
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
		
}