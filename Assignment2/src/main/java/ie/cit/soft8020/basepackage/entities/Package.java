package ie.cit.soft8020.basepackage.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Package {

	@Id
	private String id;
	private String name;
	private double price;
	private Flower flower;
	
	
	public Package() {
	}



	public Package(String name, double price, Flower flower) {
		this.name = name;
		this.price = price;
		this.flower = flower;
	}



	public Package(String id, String name, double price,Flower flower) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.flower=flower;
		
	}
	
	
	
	public Package(Flower flower) {

		this.flower = flower;
	}



	public Flower getFlower() {
		return flower;
	}



	public void setFlower(Flower flower) {
		this.flower = flower;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
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
		return "Package [id=" + id + ", name=" + name + ", price=" + price + ", flower=" + flower
				+ "]";
	}

}
