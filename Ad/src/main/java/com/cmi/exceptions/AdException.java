package com.cmi.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.Responses;

public class AdException extends WebApplicationException {
	public AdException() {
		super(Responses.notFound().build());
	}
	
	public AdException(String message) {		
		super(Response.status(201).entity(message).build());
	}
}
