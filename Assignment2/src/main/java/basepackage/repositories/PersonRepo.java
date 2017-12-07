package basepackage.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import basepackage.entities.Person;

public interface PersonRepo extends MongoRepository<Person, Integer>
{
	
}
