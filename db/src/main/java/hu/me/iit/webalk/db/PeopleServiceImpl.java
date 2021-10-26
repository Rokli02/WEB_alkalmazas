package hu.me.iit.webalk.db;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl implements PeopleService {
	private final PeopleRepository peopleRepository;
	
	public PeopleServiceImpl(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}
	
	@Override
	public Iterable<People> gettAllPeople() {
		return peopleRepository.findAll();
	}

}
