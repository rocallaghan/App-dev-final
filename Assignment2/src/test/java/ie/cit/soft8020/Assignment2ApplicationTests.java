package ie.cit.soft8020;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ie.cit.soft8020.basepackage.entities.Person;
import ie.cit.soft8020.basepackage.entities.repositories.PersonRepo;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Assignment2ApplicationTests {

	@Autowired
	PersonRepo personDAO;
	List<Person> preExistingData;

	//Before and after will trigger before and after each test. Ideally they should trigger once 
	//but beforeClass and afterClass need to be static methods which causes problems
	@Before
	public void before()
	{

		System.out.println("Junit set up");
		preExistingData = personDAO.findAll();
		personDAO.deleteAll();
	

	}
	@After
	public void after()
	{
		System.out.println("Junit tear down");
		personDAO.deleteAll();
		personDAO.insert(preExistingData);
	}


	@Test
	public void testPersonFindOne()
	{
		//Test find by name
		Person expected = new Person(6,"TEST Person",45,"TEST@gmail.com");
		personDAO.insert(expected);
		Person actual = personDAO.findOne((int) 6);;
		assertEquals(expected.getName(),actual.getName());
		assertEquals(expected.getId(),expected.getId());
		assertEquals(expected.getAge(),expected.getAge());
	}	

	
}
