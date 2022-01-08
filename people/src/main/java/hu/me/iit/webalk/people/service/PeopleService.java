package hu.me.iit.webalk.people.service;

public interface PeopleService {
	Iterable<People> findAllPeople();
	People findPeopleById(Long id);
	People createPeople(People people);
}
