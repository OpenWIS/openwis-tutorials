package com.owt7.api;


/**
 * 
 * Interfaces define a set of functionality as a rule or a contract. 
 * An interface implementtation must implement all of the declared functionality in the concrete class.
 * The advantage of OSGi service implementations can be swapped even at runtime.
 * 
 */
public interface EchoService {
    
    String echo(String text);

}
