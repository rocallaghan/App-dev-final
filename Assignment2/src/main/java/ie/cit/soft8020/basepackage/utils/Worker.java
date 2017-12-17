package ie.cit.soft8020.basepackage.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import ie.cit.soft8020.basepackage.entities.Cart;
import ie.cit.soft8020.basepackage.entities.Flower;
import ie.cit.soft8020.basepackage.entities.Order;
import ie.cit.soft8020.basepackage.entities.CustomerOrder;
import ie.cit.soft8020.basepackage.entities.Package;
import ie.cit.soft8020.basepackage.entities.repositories.OrdersRepo;
import ie.cit.soft8020.basepackage.entities.repositories.PackageRepo;
import ie.cit.soft8020.basepackage.entities.repositories.FlowerRepo;
import ie.cit.soft8020.basepackage.entities.repositories.PersonRepo;




@Service
public class Worker {
	
	@Autowired
	PackageRepo packRepo;
	@Autowired
	Cart cart;
	@Autowired
	OrdersRepo orderRepo;

	private RestTemplate restTemplate;
	
	private String backendURI;
	private final int FLOREST_ID=3; 
	private final String FLOREST_NAME="Phillie's flowers";
	@Autowired
	private Cart shoppingCart;
	
	public Worker()
	{
		this.restTemplate=new RestTemplate();
		this.backendURI = "http://localhost:8001";
	}
	public Cart getCart()
	{
		return this.cart;
	}
	public List<Package> presets()
	{
		return packRepo.findAll();
	}
	public Order[] myOrders()
	{
		return restTemplate.getForObject(backendURI+"/myOrders?id="+FLOREST_ID, Order[].class);	
	}
	public Flower[] getFlowers()
	{
		Flower[] f =restTemplate.getForObject(backendURI+"/allFlowers", Flower[].class);
		return f;
	}
	
	public void addToShoppingCart(Package pack)
	{
		shoppingCart.add(pack);
	}
	public void deleteOrder(String id)
	{
		restTemplate.delete(backendURI+"/deleteOrder/"+id);
	}
	public Flower getFlowerDetails(String id)
	{
		return restTemplate.getForObject(backendURI+"/flowerDetails?id="+id, Flower.class);
	}
	public List<CustomerOrder> getCustomerOrders()
	{
		return orderRepo.findAll();
	}
	public void removeFromCart(String id)
	{
		cart.removePackage(id);
	}
	public void addCustomPackageToCart(Package pack )
	{
		
		String flowerId = pack.getFlower().getId();
		
		Flower flower = getFlowerDetails(flowerId);
		
		pack.getFlower().setName(flower.getName());
		pack.getFlower().setPrice(flower.getPrice());
		
		
		pack.setPrice((pack.getFlower().getQuantity()*pack.getFlower().getPrice()));
		
		String uniqueID = UUID.randomUUID().toString();
		pack.setId(uniqueID);
		if(pack.getName().equalsIgnoreCase(""))
			pack.setName("Custom package");
		addToShoppingCart(pack);
	}
	
	
	
	
	
	@Transactional 
	public boolean makeOrder(CustomerOrder order)
	{
		order.setCost(cart.getTotalCost());
		order.setPackages(cart.getPackages());
		orderRepo.save(order);
		ArrayList<Flower> flowersToOrder = new ArrayList<Flower>();
		
		
		ArrayList<Flower> flowersInOrder= new ArrayList<Flower>();
		for(Package orderPackage:order.getPackages())
		{
			flowersInOrder.add(orderPackage.getFlower());		
		}
		
		
		Flower[] flowers = getFlowers();
		for (Flower flower:flowers)
		{
			flower.setQuantity(0);
			flowersToOrder.add(flower);
		}
		
		
		for(Flower flower : flowersToOrder)
		{
			for(Flower flower2 : flowersInOrder)
			{
				if(flower.getId().equalsIgnoreCase(flower2.getId()))
				{
					flower.setQuantity(flower.getQuantity()+flower2.getQuantity());
				}
			}
		}
		
		double totalCost=0;
		for(Flower flower : flowersToOrder)
		{
			totalCost+=(flower.getQuantity()*flower.getPrice());
		}
		
		
		Order florestOrder = new Order(FLOREST_ID,FLOREST_NAME,flowersToOrder,totalCost);
		
		boolean responce =restTemplate.postForObject(backendURI+"/makeOrder", florestOrder, Boolean.class);
		cart.empty();
		return responce;
	}

}
