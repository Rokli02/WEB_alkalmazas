package hu.me.iit.webalk.db.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PeopleRepository extends PagingAndSortingRepository<People, Long>{
	Iterable<People> findAllByAgeGreaterThanEqual(int age);
}
