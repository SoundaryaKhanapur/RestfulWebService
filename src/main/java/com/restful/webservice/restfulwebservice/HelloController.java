package com.restful.webservice.restfulwebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping(path = "/helloworld")
	public String helloWorld() {
		return "Hello World!";
	}
	
	@GetMapping(path = "/helloworld-bean")
	public HelloWorld helloWorldBean() {
		return new HelloWorld("HelloWorld");
	}
	
	@GetMapping(path = "/helloworld/pathvariable/{name}")
	public HelloWorld helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorld(String.format("HelloWorld, %s", name));
	}
}
