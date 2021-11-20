package hu.me.iit.webalk.tree.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import hu.me.iit.webalk.tree.service.Tree;

public class TreeDto {
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String className;
	@NotEmpty
	private String crop;
	@Min(3)
	private Integer maxHeightInMeter;
	
	public TreeDto() {}

	public TreeDto(Tree tree) {
		this.id = tree.getId();
		this.name = tree.getName();
		this.className = tree.getClassName();
		this.crop = tree.getCrop();
		this.maxHeightInMeter = tree.getMaxHeight();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getClassName() {
		return className;
	}

	public String getCrop() {
		return crop;
	}

	public Integer getMaxHeightInMeter() {
		return maxHeightInMeter;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setCrop(String crop) {
		this.crop = crop;
	}

	public void setMaxHeightInMeter(Integer maxHeightInMeter) {
		this.maxHeightInMeter = maxHeightInMeter;
	}

	public Tree toTree() {
		return new Tree(this.id, this.name, this.className, this.crop, this.maxHeightInMeter);
	}
}
