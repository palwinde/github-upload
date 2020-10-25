package com.adidas.apiEngine.model;
/** Represents the model of
 * Category used for Pet
 * representing the 
 * id and name of category
 * @author Palwinder
 * @version 1.0
 * @since 1.0
*/
public class Category {
private int id;
private String name;


public Category(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}



}
