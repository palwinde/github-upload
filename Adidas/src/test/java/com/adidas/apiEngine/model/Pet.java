package com.adidas.apiEngine.model;


import java.util.TreeMap;
/** Represents Model of Pet
 * to be used by different api methods
 * called in step definition methods
 * mapped to feature file 
 * @author Palwinder
 * @version 1.0
 * @since 1.0
*/
public class Pet {
	
	private int id;
	private String name;
	private Category category;
	private TreeMap<String,String> photoUrls;
	private  TreeMap<String,String>tags;
	private PetStatus status;
	
	public Pet(int id, Category category,String name, TreeMap<String, String> photoUrls, TreeMap<String, String> tags,
			PetStatus status) {
		super();
		this.id = id;
		this.name=name;
		this.category = category;
		this.photoUrls = photoUrls;
		this.tags = tags;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public TreeMap<String, String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(TreeMap<String, String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public TreeMap<String, String> getTags() {
		return tags;
	}
	public void setTags(TreeMap<String, String> tags) {
		this.tags = tags;
	}
	public PetStatus getStatus() {
		return status;
	}
	public void setStatus(PetStatus pet1) {
		this.status = pet1;
	}
	

}
