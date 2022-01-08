package hu.me.iit.webalk.people.controller;

import org.springframework.web.bind.annotation.*;

import hu.me.iit.webalk.people.service.PeopleService;
import lombok.AllArgsConstructor;

import javax.validation.Valid;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/people")
@AllArgsConstructor
public class PeopleController {
	private final PeopleService peopleService;

	@GetMapping
	public Iterable<PeopleDto> findAllPeople() {
		return StreamSupport.stream(peopleService.findAllPeople().spliterator(), false)
				.map(PeopleDto::new)
				.collect(Collectors.toList());
	}

	@GetMapping("/byID")
	public PeopleDto findById(@RequestParam Long id) {
		return new PeopleDto(peopleService.findPeopleById(id));
	}

	@PostMapping("/post")
	public PeopleDto createPeople(@RequestBody @Valid PeopleCreateDto peopleDto) {
		return new PeopleDto(peopleService.createPeople(peopleDto.toPeople()));
	}
}
