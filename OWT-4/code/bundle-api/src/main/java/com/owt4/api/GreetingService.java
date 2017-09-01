package com.owt4.api;

import java.util.List;

/**
 * 
 * Interfaces define a set of functionality as a rule or a contract. 
 * An interface implementtation must implement all of the declared functionality in the concrete class.
 * The advantage of OSGi service implementations can be swapped even at runtime.
 * 
 */
public interface GreetingService {
    String sayHello(String name);
    List<String> getNames();  

}
