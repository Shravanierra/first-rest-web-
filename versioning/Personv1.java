package com.restful.webservice.restweb.versioning;

public class Personv1 {
	public String name;

	public Personv1(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Personv1 [name=" + name + "]";
	}
	

}
