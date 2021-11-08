package hu.me.iit.webalk.db.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.me.iit.webalk.db.service.People;
import hu.me.iit.webalk.db.service.PeopleService;

@RestController
@RequestMapping("/people")
public class PeopleController {
	private final PeopleService peopleService;
	
	
	public PeopleController(PeopleService peopleService) {
		this.peopleService = peopleService;
	}



	@GetMapping
	public Iterable<PeopleDto> getAllPeople() {
		List<PeopleDto> peopleDtoList = new ArrayList<>();
		for (People people : peopleService.getAllPeople()) {
			peopleDtoList.add(new PeopleDto(people));
		}
		
		return peopleDtoList;
	}
	
	@PostMapping(consumes = "application/json")
	public PeopleDto save(@RequestBody @Valid PeopleCreateDto peopleCreateDto) {
		return new PeopleDto(peopleService.create(peopleCreateDto.toPeople()));
	}
	
}
