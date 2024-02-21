package com.restful.webservice.restweb.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;


@RestController
public class FilteringController {
	@GetMapping("/filtering")
	public MappingJackSonValue filtering() {
		SomeBean someBean= new SomeBean("value1","value2","value3");
		MappingJacksonValue mappingJacksonValue=
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept(null);
		
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> filteringList() {
		return Arrays.asList(new SomeBean("value1","value2","value3"),
				new SomeBean("value4","value5","value6"));
	}

}
