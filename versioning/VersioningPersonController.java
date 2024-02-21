package com.restful.webservice.restweb.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	@GetMapping("/v1/person")
	public Personv1 getFirstVersionOfPerson() {
		return new Personv1("zu dio");
	}
	@GetMapping("/v2/person")
	public Personv2 getSecondVersionOfPerson() {
		return new Personv2(new Name("zu","dio"));
	}
	@GetMapping(path="/person",params="version=1")
	public Personv1 getFirstVersionOfPersonRequestParameter() {
		return new Personv1("zu dio");
	}
	@GetMapping(path="/person/header",headers="X-API-VERSION=1")
	public Personv1 getFirstVersionOfPersonRequestHeader() {
		return new Personv1("zu dio");
	}
	
	@GetMapping(path="/person/accept", produces="application/vnd.company.app-v1+json")
	public Personv1 getFirstVersionOfPersonAcceptHeader() {
		return new Personv1("zu dio");
	}
}
