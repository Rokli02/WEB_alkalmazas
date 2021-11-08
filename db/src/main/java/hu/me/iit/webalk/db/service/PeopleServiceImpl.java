package hu.me.iit.webalk.db.service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
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

	
}

/*
	@Override
	public Iterable<People> gettAllPeople() {
		List<People> rv = new ArrayList<>();
		
		StreamSupport.stream(peopleRepository.findAll().spliterator(), false);
		for(hu.me.iit.webalk.db.repository.People people : peopleRepository.findAll()) {
			rv.add(new People(people));
		}
		
		return rv;
	}*/