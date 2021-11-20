package hu.me.iit.webalk.tree.service;

import hu.me.iit.webalk.tree.repository.TreeEntity;

public class Tree {
	private Long id;
	private String name;
	private String className;
	private String crop;
	private Integer maxHeight;
	
	public Tree() {}

	public Tree(Long id, String name, String className, String crop, Integer maxHeight) {
		this.id = id;
		this.name = name;
		this.className = className;
		this.crop = crop;
		this.maxHeight = maxHeight;
	}
	
	public Tree(TreeEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.className = entity.getClassName();
		this.crop = entity.getCrop();
		this.maxHeight = entity.getMaxHeight();
	}
	
	public TreeEntity toEntity() {
		return new TreeEntity(id, name, className, crop, maxHeight);
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

	public Integer getMaxHeight() {
		return maxHeight;
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

	public void setMaxHeight(Integer maxHeight) {
		this.maxHeight = maxHeight;
	}
	
	
}
