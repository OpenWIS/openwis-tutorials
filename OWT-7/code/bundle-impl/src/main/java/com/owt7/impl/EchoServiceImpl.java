package com.owt7.impl;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.ops4j.pax.cdi.api.OsgiService;
import org.ops4j.pax.cdi.api.OsgiServiceProvider;

import com.owt7.api.EchoService;
import com.owt7.api.EchoDatabaseService;
import com.owt7.api.dto.MessageDTO;
import com.owt7.lib.DemoUtil;

/**
 * 
 * @Singleton = a single instance is reused
 * 
 * @OsgiServiceProvider = OSGi reference to interface class.
 * 
 */

@Singleton
@OsgiServiceProvider(classes = { EchoService.class })
public class EchoServiceImpl implements EchoService {

	@Inject
	@OsgiService
	private EchoDatabaseService echoDatabaseService;	
	
	public String echo(String text) {

		DemoUtil util = new DemoUtil();
		MessageDTO message = new MessageDTO();
		
		message.setMessage(util.upperCaseIt(text));
		Integer id = echoDatabaseService.create(message);
		
		int min = 1;
		int max = 2;
		try {
			int randomDelay = ThreadLocalRandom.current().nextInt(min, max + 1);
			TimeUnit.SECONDS.sleep(randomDelay);
			System.out.println("calling update with id "+ id);
			
			echoDatabaseService.update(id);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return echoDatabaseService.get(id).getMessage();
	}

}