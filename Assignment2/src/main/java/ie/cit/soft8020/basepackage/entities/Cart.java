package ie.cit.soft8020.basepackage.entities;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class Cart {
	ArrayList<Package> listOfPackages;
	int cost;
	boolean isFinished;
	
	public Cart() {
		listOfPackages = new ArrayList<Package>();
		cost=0;
	}
	public ArrayList<Package> getListOfPackages() {
		return listOfPackages;
	}
	public void setListOfPackages(ArrayList<Package> listOfPackages) {
		this.listOfPackages = listOfPackages;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public void addPackage(Package packageToAdd){//Add package to list and cost
		listOfPackages.add(packageToAdd);
		cost += packageToAdd.getPrice();
	}
	
	public void removePackage(int id){//Remove package and cost from list
		isFinished = false;//Changes to true when package is removed, leaving the while loop
		while (isFinished = false){
			for (Package packageToRemove : listOfPackages){
				if (packageToRemove.getId() == id){
					cost -= packageToRemove.getPrice();
					listOfPackages.remove(packageToRemove);
					isFinished = true;
				}
			}
		}
	}
}
