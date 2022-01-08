package hu.me.iit.webalk.people.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class People {
	private Long id;
	private String name;
	private String nickname;
	private Integer age;
	private String lakohely;
	
	public People(hu.me.iit.webalk.people.repository.People people) {
		this.id = people.getId();
		this.name = people.getName();
		this.nickname = people.getNickname();
		this.age = people.getAge();
		this.lakohely = people.getLakohely();
	}

	public hu.me.iit.webalk.people.repository.People toEntity() {
		return new hu.me.iit.webalk.people.repository.People(id, name, nickname, age, lakohely);
	}
}
