package com.restful.webservice.restweb.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {
	
	private MessageSource messageSource;
	public Helloworld(MessageSource messageSource) {
		this.messageSource=messageSource;
	}
	

	@GetMapping(path="/hello-world")
	public String helloworld() {
		return "Hello World";
		
	}
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloworldBean() {
		return new HelloWorldBean("Hello World");

}
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloworldPathvariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World,%s",name));

}
	@GetMapping(path="/hello-world-internationalised")
	public String helloworldInternationalised() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message",null,"Default Message",locale );
		//return "Hello World v2";
		
	}
}