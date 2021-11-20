package hu.me.iit.webalk.tree.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import hu.me.iit.webalk.tree.service.Tree;

public class TreeCreateDto {
	@NotEmpty
	private String name;
	@NotEmpty
	private String className;
	@NotEmpty
	private String crop;
	@Min(3)
	private int maxHeightInMeter;
	
	public TreeCreateDto() {}

	public TreeCreateDto(String name, String className, String crop,int maxHeightInMeter) {
		this.name = name;
		this.className = className;
		this.crop = crop;
		this.maxHeightInMeter = maxHeightInMeter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCrop() {
		return crop;
	}

	public void setCrop(String crop) {
		this.crop = crop;
	}

	public int getMaxHeightInMeter() {
		return maxHeightInMeter;
	}

	public void setMaxHeightInMeter(int maxHeightInMeter) {
		this.maxHeightInMeter = maxHeightInMeter;
	}
	
	public Tree toTree() {
		return new Tree(null, this.name, this.className, this.crop, this.maxHeightInMeter);
	}
	
	
}
