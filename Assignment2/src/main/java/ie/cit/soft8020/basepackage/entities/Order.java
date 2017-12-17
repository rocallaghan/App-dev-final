package ie.cit.soft8020.basepackage.entities;

import java.util.ArrayList;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
	@Id 
	private String id;
	private ArrayList<Flower> contents;
	private double cost;
	private int quantity;
	

	
	
	public Order(String id, ArrayList<Flower> contents, double cost,int quantity) {
		this.id = id;
		this.contents = contents;
		this.cost = cost;
		this.quantity = quantity;
	}
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Flower> getContents() {
		return contents;
	}
	public void setContents(ArrayList<Flower> contents) {
		this.contents = contents;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		String order = "OrderId:"+this.id+"\nContents:";
		for(Flower flower : this.contents)
		{
			order = order +"\n"+flower.toString();
		}
		order=order+"\nCost:"+this.cost + "\nQuantity: "+this.quantity;
		return order;
	}
}
