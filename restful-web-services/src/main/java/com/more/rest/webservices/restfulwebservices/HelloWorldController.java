package com.more.rest.webservices.restfulwebservices;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.LocaleResolver;

@RestController
public class HelloWorldController {
	
	//@Autowired
	//LocaleResolver localeResolver;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	public String helloWorld() {
		return "Hello - Welcome Webservices world" ;
		
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/hello-world-i18n")
	public String helloWorldi18n(@RequestHeader(name="Accept-language", required=false) Locale locale) {
		return  messageSource.getMessage("good.morning.message", null, locale);
		
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World...");		
	}

	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
		
	}
}
