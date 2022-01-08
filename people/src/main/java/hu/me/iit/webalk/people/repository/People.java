package hu.me.iit.webalk.people.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class People {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String nickname;
	private Integer age;
	private String lakohely;
}
