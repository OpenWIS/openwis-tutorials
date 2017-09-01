package com.owt4.impl;

import org.ops4j.pax.cdi.api.OsgiServiceProvider;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

import com.owt4.api.GreetingService;
import com.owt4.lib.DemoUtil;

/**
 * 
 * @Singleton = a signle instance is reused
 * 
 * @OsgiServiceProvider = OSGi reference to interface class.
 * 
 */

@Singleton
@OsgiServiceProvider(classes = { GreetingService.class })
public class GreetingServiceImpl implements GreetingService {

    final List<String> people = new ArrayList<>();

    public String sayHello(String name) {
        DemoUtil util = new DemoUtil();
        // Since there is no database:
        people.add(name);
        return "Hello " + util.upperCaseIt(name);
    }

    //For the current tutorial we wont use data base , but a simple list..
    public List<String> getNames() {
        return people;
    }
}