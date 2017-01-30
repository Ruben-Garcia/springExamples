package com.udemy.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("exampleComponent")
public class ExampleComponent {

	private static final Log log = LogFactory.getLog(ExampleComponent.class);
	
	public void sayHello(){
		log.info("Hello from example component");
		
	}
}
