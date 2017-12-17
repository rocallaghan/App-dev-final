package ie.cit.soft8020.basepackage.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Package {

	@Id
	private int id;
	private String name;
	private double price;
	private Flower flower;
	
	
	public Package() {
	}


	public Package(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
		
	}

//dfdsvsdf
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
	public double getPrice() {
		
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "Package [id=" + id + ", name=" + name + ", price=" + price 
				+ "]";
	}

}
