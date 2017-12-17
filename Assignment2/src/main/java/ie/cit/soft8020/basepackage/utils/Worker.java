package ie.cit.soft8020.basepackage.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ie.cit.soft8020.basepackage.entities.Cart;
import ie.cit.soft8020.basepackage.entities.Flower;
import ie.cit.soft8020.basepackage.entities.Package;
import ie.cit.soft8020.basepackage.entities.repositories.PackageRepo;




@Service
public class Worker {
	@Autowired
	PackageRepo packageRepo;
	@Autowired
	Cart cart;
	
	RestTemplate restTemplate;
	String backendURL;
	
	public Worker(){
		this.restTemplate = new RestTemplate();
		this.backendURL = "http://localhost:8080";
	}
	
	public Cart getCart(){
		return cart;
	}
	
	public List<Package> packages(){
		return packageRepo.findAll();
	}
	
	public Flower[] getFlowers(){
		Flower[] f = restTemplate.getForObject(backendURL+"/allFlowers", Flower[].class);
		return f;
	}
	
	public void addToCart(Package packageToAdd){
		cart.addPackage(packageToAdd);
	}
	
	public void removeFromCart(int id) {
		cart.removePackage(id);
	}
}
