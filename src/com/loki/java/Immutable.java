package com.loki.java;

public final class Immutable {

	private int personid;
	private String name;
	private final Person person;
	
	public Immutable() {
		person = new Person();
	}
	
	public Immutable(Person p) {
		
		person = new Person();
		person.age = p.age; 
	}
	
	public int getPersonid() {
		return personid;
	}

	public String getName() {
		return name;
	}

	public Person getPerson() {
		return person;
	}

	public static void main(String[] args) {
		
	}

}
