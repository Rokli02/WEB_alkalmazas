package hu.me.iit.webalk.db.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import hu.me.iit.webalk.db.repository.PeopleRepository;

@Service
public class PeopleServiceImpl implements PeopleService {
	private final PeopleRepository peopleRepository;
	
	public PeopleServiceImpl(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}
	
	
	@Override
	public Iterable<People> getAllPeople() {
		
		return StreamSupport.stream(peopleRepository.findAll().spliterator(), false)
				.map(People::new)
				.collect(Collectors.toList());
	}


	@Override
	public People create(People people) {
		return new People(peopleRepository.save(people.toEntity()));
	}

	@Override
	public void delete(Long id) {
		try {
		peopleRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new NoSuchEntityException(id);
		}
		
	}


	@Override
	public People getById(Long id) {
		Optional<hu.me.iit.webalk.db.repository.People> optionalPeople = peopleRepository.findById(id);
		if(optionalPeople.isEmpty()) {
			throw new NoSuchEntityException(id);
		}
		return new People(optionalPeople.get());
	}


	@Override
	public void save(People people) {
		Optional<hu.me.iit.webalk.db.repository.People> optionalPeople = peopleRepository.findById(people.getId());
		if(optionalPeople.isEmpty()) {
			throw new NoSuchEntityException(people.getId());
		}
		peopleRepository.save(people.toEntity());
		
	}


	@Override
	public Iterable<People> findByAgeGreaterThan(int age) {
		return StreamSupport.stream(peopleRepository.findAllByAgeGreaterThanEqual(age).spliterator(), false)
				.map(People::new)
				.collect(Collectors.toList());
	}
	
	
	
}
