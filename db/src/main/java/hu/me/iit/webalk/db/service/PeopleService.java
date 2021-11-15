package hu.me.iit.webalk.db.service;

public interface PeopleService {
	Iterable<People> getAllPeople();
	People create(People people);
	void delete(Long id);
	People getById(Long id);
	void save(People people);
	Iterable<People> findByAgeGreaterThan(int age);
}
