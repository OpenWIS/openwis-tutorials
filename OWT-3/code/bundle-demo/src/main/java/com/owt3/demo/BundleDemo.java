package com.owt3.demo;

import javax.inject.Inject;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import org.ops4j.pax.cdi.api.OsgiService;

import com.owt3.api.GreetingService;

/**
 * 
 * @OsgiService = a reference to an OSGi service.
 * 
 * @Singleton = a signle instance is reused
 * 
 * @Inject = identifies the point at which a dependency on a class or interface can be injected.
 * 
 * @PostConstruct = that method needs to be executed after dependency injection is done to perform any initialization. 
 * 
 */
@Singleton
public class BundleDemo {

 @OsgiService
 @Inject
 private GreetingService greetingService;

    @PostConstruct
    public void init() {
        String user = "auser"; 
        System.out.println("Demo Bundle is calling GreetingService:");
        System.out.println(" "+greetingService.sayHello(user));
    }
}




