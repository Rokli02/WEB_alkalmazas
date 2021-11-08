package hu.me.iit.webalk.db.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import hu.me.iit.webalk.db.service.People;

public class PeopleCreateDto {
	@NotEmpty
	private String name;
	@Size(min = 18)
	private int age;
	
	public PeopleCreateDto() {
		
	}
	public PeopleCreateDto(People people) {
		this.name = people.getName();
		this.age = people.getAge();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public People toPeople() {
		return new People(null, age, name);
	}
}
