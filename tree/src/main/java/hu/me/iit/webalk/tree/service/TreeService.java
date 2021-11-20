package hu.me.iit.webalk.tree.service;

public interface TreeService {
	Tree create(Tree tree);
	Iterable<Tree> findAll();
	void delete(Long id);
	Tree findTreeById(Long id);
	Tree updateTree(Tree tree);
	Tree patchTree(Tree tree);
	Iterable<Tree> findAllBetween(Integer lower, Integer upper);
}
