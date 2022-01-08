package hu.me.iit.webalk.people.controller;

import hu.me.iit.webalk.people.service.People;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleDto {
	private Long id;
	private String name;
	private String nickname;
	private Integer age;
	private String lakohely;
	
	public PeopleDto(People people) {
		this.id = people.getId();
		this.name = people.getName();
		this.nickname = people.getNickname();
		this.age = people.getAge();
		this.lakohely = people.getLakohely();
	}

	public People toPeople() {
		return new People(id, name, nickname, age, lakohely);
	}
}
