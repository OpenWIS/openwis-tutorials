package com.owt4.rest;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.ops4j.pax.cdi.api.OsgiService;

import com.owt4.api.GreetingService;
import com.owt4.api.dto.ResponseDTO;


@Singleton
/**
 * 
 * GreeterResource
 * 
 * @Singleton to declare to blueprint plugin as bean.
 * 
 * 
 */
public class GreeterResource {

	@Inject
	@OsgiService
	private GreetingService greetingService;

	// This is the REST endpoint:
	@POST
	@Path("/greeter")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public ResponseDTO greetPost(@FormParam("name") String name) {
		if (name == null || name.isEmpty()) 
			name = "No name? I will call you Jack Sparrow";
		return new ResponseDTO("From POST: " + greetingService.sayHello(name));
	}

	@GET
	@Path("/greeter")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseDTO greetGet(@QueryParam("name") String name) {
		if (name == null || name.isEmpty()) 
			name = "No name? I will call you Jack Sparrow";
		return new ResponseDTO("From GET: " + greetingService.sayHello(name));
	}

	@GET
	@Path("/aNotAllowedMethod")
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveSomething() {
		return Response.status(Status.METHOD_NOT_ALLOWED.getStatusCode()).build();
	}
}
