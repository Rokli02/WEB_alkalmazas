package hu.me.iit.webalk.people.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import hu.me.iit.webalk.people.repository.PeopleRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PeopleServiceImpl implements PeopleService {
	private final PeopleRepository peopleRepository;
	
	@Override
	public Iterable<People> findAllPeople() {
		return StreamSupport.stream(peopleRepository.findAll().spliterator(), false)
				.map(People::new)
				.collect(Collectors.toList());
	}

	@Override
	public People findPeopleById(Long id) {
		Optional<hu.me.iit.webalk.people.repository.People> optPeople = peopleRepository.findById(id);
		if(optPeople.isPresent())
			return new People(optPeople.get());
		throw new NoSuchElementException();
	}

	@Override
	public People createPeople(People people) {
		return new People(peopleRepository.save(people.toEntity()));
	}

}
