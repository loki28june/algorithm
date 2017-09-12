package com.loki.corejava;

public final class Immutable {

	private int personid;
	private String name;
	private final ComparableAndComparator person;
	
	public Immutable() {
		person = new ComparableAndComparator();
	}
	
	public Immutable(ComparableAndComparator p) {
		
		person = new ComparableAndComparator();
		person.age = p.age; 
	}
	
	public int getPersonid() {
		return personid;
	}

	public String getName() {
		return name;
	}

	public ComparableAndComparator getPerson() {
		return person;
	}

	public static void main(String[] args) {
		
	}

}
