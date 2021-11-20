package hu.me.iit.webalk.tree.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.me.iit.webalk.tree.service.Tree;
import hu.me.iit.webalk.tree.service.TreeService;

@RestController
@RequestMapping("/tree")
public class TreeController {
	private TreeService treeService;

	public TreeController(TreeService treeService) {
		this.treeService = treeService;
	}
	
	@GetMapping
	public Iterable<TreeDto> getAllTrees() {
		List<TreeDto> treeDtoList = new ArrayList<>();
		for(Tree tree : treeService.findAll()) {
			treeDtoList.add(new TreeDto(tree));
		}
		return treeDtoList;
	}
	
	@PostMapping(consumes = "application/json")
	public TreeDto createTree(@RequestBody @Valid TreeCreateDto treeCreateDto) {
		return new TreeDto(treeService.create(treeCreateDto.toTree()));
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteTree(@PathVariable("id") Long id) {
		treeService.delete(id);
	}
	
	@GetMapping("/{id}")
	public TreeDto getTree(@PathVariable("id") Long id) {
		return new TreeDto(treeService.findTreeById(id));
	}
	
	@PutMapping
	public TreeDto update(@RequestBody @Valid TreeDto treeDto) {
		return new TreeDto(treeService.updateTree(treeDto.toTree()));
	}
	
	@PatchMapping
	public TreeDto patch(@RequestBody TreeDto treeDto) {
		return new TreeDto(treeService.patchTree(treeDto.toTree()));
	}
	
	@GetMapping("/height{lower}/{upper}")
	public Iterable<TreeDto> maxHeightBetween(@PathVariable("lower") Integer lower, @PathVariable("upper") Integer upper) {
		return StreamSupport.stream(treeService.findAllBetween(lower, upper).spliterator(), false)
				.map(TreeDto::new)
				.collect(Collectors.toList());
	}
}
