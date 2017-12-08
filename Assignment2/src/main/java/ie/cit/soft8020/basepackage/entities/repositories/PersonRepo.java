package ie.cit.soft8020.basepackage.entities.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ie.cit.soft8020.basepackage.entities.Person;

public interface PersonRepo extends MongoRepository<Person, Integer>
{
	
}
