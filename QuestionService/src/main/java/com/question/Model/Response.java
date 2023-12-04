package com.question.Model;

public class Response {
	private long id;
	private String response;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Response(long id, String response) {
		super();
		this.id = id;
		this.response = response;
	}
	

}
