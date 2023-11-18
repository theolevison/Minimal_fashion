package com.theo.minimal_fashion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Controller {
	private Person person;
	
	public static void main(String[] args) {
		SpringApplication.run(Controller.class, args);
		
		//do stuff
		System.out.println("started");
		
		DynamoDBAbstraction db = new DynamoDBAbstraction();
		//db.get("tshirt", "Torso");
		
		//create object to put in table
		//TODO: use a factory method to bring back Torso, Legs etc
		TorsoClothingFactory tcf = new TorsoClothingFactory();
		Clothing tshirt = tcf.setupClothing("red tshirt");
		
		//all optional
		/**
		tshirt.setCondition(10);
		tshirt.setLayerable(true);
		tshirt.setStyleRating(0);
		tshirt.setTemperatureRating(5);
		tshirt.testMethod();
		*/
		
		db.put(tshirt);
		db.superGet("Torso", "red tshirt");
		//Clothing testShirt = db.get("Torso", "red tshirt");
	}
	
	@GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }
	
	public void addPerson(String name) {
		if (person.equals(null)) {
			person = new Person(name);
		}
	}
	
	public void addClothing(ClothingFactory cf) {
		Clothing clothing = cf.createClothing();
		person.addClothingKeys(clothing);
	}
}