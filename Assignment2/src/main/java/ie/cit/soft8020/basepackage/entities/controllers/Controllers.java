package ie.cit.soft8020.basepackage.entities.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ie.cit.soft8020.basepackage.entities.Flower;
import ie.cit.soft8020.basepackage.entities.Person;
import ie.cit.soft8020.basepackage.entities.repositories.FlowerRepo;
import ie.cit.soft8020.basepackage.entities.repositories.PersonRepo;

@Controller
public class Controllers {
	@Autowired
	PersonRepo personRepo;
	@Autowired
	FlowerRepo flowerRepo;
	/**
	 * Calls index.html
	 */
	 @GetMapping("/")
	    public String home1() {
	        return "/home";
	    }

	    @GetMapping("/home")
	    public String home() {
	        return "/home";
	    }

	    @GetMapping("/index")
	    public String user() {
	        return "/index";
	    }

	   
	    
	    @GetMapping("/adminIndex")
	    public String adminIndex(Model model) {
	    	List<Person> p = personRepo.findAll();
			model.addAttribute("people", p);
			List<Flower> f = flowerRepo.findAll();
			model.addAttribute("flower", f);
	        return "/adminIndex";
	    }


	    @GetMapping("/about")
	    public String about() {
	        return "/about";
	    }

	    @GetMapping("/login")
	    public String login() {
	        return "/loginPage";
	    }

	    @GetMapping("/403")
	    public String error403() {
	        return "/error/403";
	    }

	
	@GetMapping("/PresetPackagesPage")
	public String presetPackagepageget(Model model)
	{
		return "PresetPackagesPage";
	}
	/*
	 * An example of using a path variable.
	 * localhost:8080/usingParameter?name=Cliona will add Cliona to the welcome
	 * localhost:8080/usingParameter uses the default value of To You!
	 */
	@GetMapping("/usingParameter")
	public String doWelcomeWithParams(@RequestParam(value="name", defaultValue="To you!")String name, Model model)
	{
		String sentence = "Welcome " + name;
		model.addAttribute("message", sentence);
		return "parameter";
	}
	/*
	 * The repository uses the in-built findAll() method of MongoRepository
	 * This returns a list of People
	 * This list is added to the model
	 * The model is sent to the displayAll.html template.
	 */
	@GetMapping("/displayall")
	public String displayAll(Model model)
	{
		List<Person> p = personRepo.findAll();
		model.addAttribute("people", p);
		List<Flower> f = flowerRepo.findAll();
		model.addAttribute("flower", f);
		return "displayAll";
	}
	/*
	 * This uses a PathVariable to specify the id being searched for.
	 * findOne() is the default method to search for one record using MongoRepository.
	 * It returns one record.
	 * This record is added to the model.
	 * The model is sent to the displayOne.html resolver.
	 */
	@GetMapping("/displayOne/{id}")
	public String showMyDetails(@PathVariable int id, Model model)
	{
		Person p = (Person) personRepo.findOne((int) id);
		model.addAttribute("person", p);
		return "displayOne";
	}

}


