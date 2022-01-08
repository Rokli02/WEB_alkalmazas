package hu.me.iit.webalk.people.controller;

import hu.me.iit.webalk.people.service.People;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleCreateDto {
	@NotEmpty
	private String name;
	@NotEmpty
	private String nickname;
	@Min(13)
	private Integer age;
	@NotEmpty
	private String lakohely;

	public PeopleCreateDto(People people) {
		this.name = people.getName();
		this.nickname = people.getNickname();
		this.age = people.getAge();
		this.lakohely = people.getLakohely();
	}

	public People toPeople() {
		return new People(null, name, nickname, age, lakohely);
	}
}
