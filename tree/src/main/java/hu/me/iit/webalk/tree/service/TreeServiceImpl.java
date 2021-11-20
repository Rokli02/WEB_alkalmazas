package hu.me.iit.webalk.tree.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import hu.me.iit.webalk.tree.repository.TreeEntity;
import hu.me.iit.webalk.tree.repository.TreeRepository;
import hu.me.iit.webalk.tree.service.exceptions.CanNotUpdateNotExistingElementException;
import hu.me.iit.webalk.tree.service.exceptions.NoSuchTreeWithThatIdException;

@Service
public class TreeServiceImpl implements TreeService {
	private final TreeRepository treeRepository;
	
	public TreeServiceImpl(TreeRepository treeRepository) {
		this.treeRepository = treeRepository;
	}

	@Override
	public Tree create(Tree tree) {
		return new Tree(treeRepository.save(tree.toEntity()));
	}

	@Override
	public Iterable<Tree> findAll() {
		return StreamSupport.stream(treeRepository.findAll().spliterator(), false)
			.map(Tree::new)
			.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		if(treeRepository.existsById(id))
			treeRepository.deleteById(id);
		else 
			throw new NoSuchTreeWithThatIdException(id);
	}

	@Override
	public Tree findTreeById(Long id) {
		Optional<TreeEntity> OptTree = treeRepository.findById(id);
		if(OptTree.isEmpty()) {
			throw new NoSuchTreeWithThatIdException(id);
		}
		return new Tree(OptTree.get());
	}

	@Override
	public Tree updateTree(Tree tree) {
		if(treeRepository.existsById(tree.getId())) {
			
			Tree updatedTree = new Tree();
			updatedTree.setId(tree.getId());
			updatedTree.setName(tree.getName());
			updatedTree.setClassName(tree.getClassName());
			updatedTree.setCrop(tree.getCrop());
			updatedTree.setMaxHeight(tree.getMaxHeight());
			
			return new Tree(treeRepository.save(updatedTree.toEntity()));
			
		} else {
			throw new CanNotUpdateNotExistingElementException(tree);
		}
	}

	@Override
	public Tree patchTree(Tree tree) {
		Optional<TreeEntity> optTree = treeRepository.findById(tree.getId());
		if(!optTree.isEmpty()) {
			Tree updatedTree = new Tree(optTree.get());
			
			if(!tree.getName().isEmpty()) {
				updatedTree.setName(tree.getName());
			}
			
			if(!tree.getClassName().isEmpty()) {
				updatedTree.setClassName(tree.getClassName());
			}
			
			if(!tree.getCrop().isEmpty()) {
				updatedTree.setCrop(tree.getCrop());
			}
			
			if(tree.getMaxHeight() != null) {
				updatedTree.setMaxHeight(tree.getMaxHeight());
			}
			
			return new Tree(treeRepository.save(updatedTree.toEntity()));
			
		} else {
			throw new CanNotUpdateNotExistingElementException(tree);
		}
	}

	@Override
	public Iterable<Tree> findAllBetween(Integer lower, Integer upper) {
		return StreamSupport.stream(treeRepository.findByMaxHeightBetween(lower, upper).spliterator(), false)
				.map(Tree::new)
				.collect(Collectors.toList());
	}

}
