package com.haotiben.feedback.Exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.haotiben.feedback.model.ErrorMessage;

/**
 *
 * @author shifeng
 */
public class RestRequestException extends WebApplicationException {

	private static final long serialVersionUID = 1L;

	public RestRequestException(ErrorMessage error) {

		super(Response.serverError().status(200).entity(error).build());
	}
}