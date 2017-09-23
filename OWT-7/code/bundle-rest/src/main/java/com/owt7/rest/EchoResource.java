package com.owt7.rest;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.ops4j.pax.cdi.api.OsgiService;

import com.owt7.api.EchoService;
import com.owt7.api.dto.MessageDTO;

@Singleton
/**
 * 
 * GreeterResource
 * 
 * @Singleton to declare to blueprint plugin as bean.
 * 
 * 
 */
public class EchoResource {

	@Inject
	@OsgiService
	private EchoService echoService;

	@POST
	@Path("/echo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public MessageDTO postMessage(MessageDTO messageDTO) {

		if (messageDTO == null || messageDTO.getMessage().isEmpty()) {			
			messageDTO = new MessageDTO();
			messageDTO.setMessage("You sent an empty message!");
		}
		String responseMessage = echoService.echo(messageDTO.getMessage());
		MessageDTO response = new MessageDTO();
		response.setMessage(responseMessage);
		return response;
	}

}
