package hu.me.iit.webalk.db.service;

public interface PeopleService {
	Iterable<People> getAllPeople();
	People create(People people);
	boolean deleteById(Long id);
}
