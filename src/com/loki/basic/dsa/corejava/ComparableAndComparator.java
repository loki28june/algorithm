package com.loki.basic.dsa.corejava;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableAndComparator implements Comparable<ComparableAndComparator> {
	Integer age;
	String name;
	String country;

	public enum Order {
		Name, Age, Country
	}

	private Order sortingBy = Order.Age;

	ComparableAndComparator() {

	}

	ComparableAndComparator(int age, String name, String country) {
		this.age = age;
		this.name = name;
		this.country = country;
	}

	public static List<ComparableAndComparator> getPersons() {
		List<ComparableAndComparator> p = new ArrayList<>();

		p.add(new ComparableAndComparator(29, "ram", "india"));
		p.add(new ComparableAndComparator(25, "zafar", "pakistan"));
		p.add(new ComparableAndComparator(28, "steve", "australia"));
		p.add(new ComparableAndComparator(27, "stokes", "england"));

		return p;
	}

	public static void main(String[] args) {
		List<ComparableAndComparator> persons = getPersons();
		System.out.println("before sort");
		printList(persons);
		Collections.sort(persons);
		System.out.println("after comparable sort");
		printList(persons);
		
			Collections.sort(persons, new Comparator<ComparableAndComparator>() {

			@Override
			public int compare(ComparableAndComparator o1, ComparableAndComparator o2) {
				return o1.name.compareTo(o2.name);

			}
		});

		System.out.println("after comparator sort");
		printList(persons);

	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", country=" + country + "]";
	}

	@Override
	public int compareTo(ComparableAndComparator person2) {
		switch (sortingBy) {
		case Name:
			return this.name.compareTo(person2.name);
		case Age:
			return this.age.compareTo(person2.age);
		case Country:
			return this.country.compareTo(person2.country);
		}
		throw new RuntimeException("Practically unreachable code, can't be thrown");
	}

	/*
	 * @Override public int compareTo(Person o) { return this.age - o.age; }
	 */

	public static void printList(List<ComparableAndComparator> Persons) {
		for (ComparableAndComparator p : Persons) {
			System.out.println(p);
		}
	}

}
