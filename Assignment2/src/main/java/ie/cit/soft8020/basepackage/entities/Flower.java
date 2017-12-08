package ie.cit.soft8020.basepackage.entities;



import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;



@Document

public class Flower {
	@Id
	int id;
	
	String name;
	String colour;
	int price;
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
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Flower(int id, String name, String colour, int price) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.price = price;
	} 	
}

