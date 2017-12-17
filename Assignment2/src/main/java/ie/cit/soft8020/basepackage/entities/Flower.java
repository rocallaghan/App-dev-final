package ie.cit.soft8020.basepackage.entities;



import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;



@Document

public class Flower {
	@Id
	String id;
	
	String name;
	String colour;
	int price;
	int quantity;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public Flower(String id, String name, String colour, int price) {
		super();
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.price = price;
	
	} 	
}

