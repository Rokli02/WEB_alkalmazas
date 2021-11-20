package hu.me.iit.webalk.tree.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TreeEntity {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String className;
	private String crop;
	private int maxHeight;
	
	public TreeEntity() {}
	
	public TreeEntity(Long id, String name, String className, String crop, int maxHeight) {
		this.id = id;
		this.name = name;
		this.className = className;
		this.crop = crop;
		this.maxHeight = maxHeight;
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
	public int getMaxHeight() {
		return maxHeight;
	}
	
	
}
