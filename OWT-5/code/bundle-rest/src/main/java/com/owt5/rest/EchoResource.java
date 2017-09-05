package com.owt5.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.ops4j.pax.cdi.api.OsgiService;

import com.owt5.api.EchoService;
import com.owt5.api.dto.MessageDTO;

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

	private static final DateFormat dateformat = new SimpleDateFormat(
			"HH:mm:ss dd/MM/yyyy");

	@POST
	@Path("/echo")
	//@Produces("application/x-www-form-urlencoded")
	//@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public MessageDTO postMessage(MessageDTO messageDTO) {
		System.out.println("POST message called "+ messageDTO);

		if (messageDTO == null || messageDTO.getMessage().isEmpty()) {
			
			messageDTO = new MessageDTO("No message??");
			
		}
		//messageDTO.setWhen(dateformat.format(Calendar.getInstance()));

		return new MessageDTO("From POST: " + echoService.echo(messageDTO.getMessage()));
	}

}
