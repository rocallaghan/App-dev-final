package ie.cit.soft8020.basepackage.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ie.cit.soft8020.basepackage.entities.repositories.FlowerRepo;
import ie.cit.soft8020.basepackage.entities.repositories.OrdersRepo;
import ie.cit.soft8020.basepackage.entities.repositories.PackageRepo;
import ie.cit.soft8020.basepackage.entities.repositories.PersonRepo;

@Component // ensures this is run because it is a bean
public class DataLoader implements ApplicationRunner{
	@Autowired // Find a PersonRepo bean and autowire it into personRepo
	PersonRepo personRepo;
	@Autowired
	FlowerRepo flowerRepo;
	@Autowired
	PackageRepo packageRepo;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception
	{
		personRepo.save(new Person(1,"Minnie Mouse", 65, "minnie@cit.ie"));
		personRepo.save(new Person(2,"Daisy Duck", 50, "daisy@cit.ie"));
		personRepo.save(new Person(3,"Gru", 56, "gru@cit.ie"));
		
		flowerRepo.save(new Flower("1","Rose", "test", 10));
		flowerRepo.save(new Flower("2","Tulip", "test2", 10));
		flowerRepo.save(new Flower("3","Lilly", "test3", 10));
		
		packageRepo.save(new Package(1, "Valentine's Day Package ", 100));
		packageRepo.save(new Package(2, "Birthday Package ", 150));
		packageRepo.save(new Package(3, "Mothers Day Package", 75));
		
		
	}
//	
//	public void saveNewPerson() throws Exception
//	{
//		
//	}
}
