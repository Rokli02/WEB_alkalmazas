package hu.me.iit.webalk.tree.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TreeRepository extends PagingAndSortingRepository<TreeEntity, Long>{
	Iterable<TreeEntity> findByMaxHeightBetween(int lower, int upper);
}
