package com.theo.minimal_fashion;

public class Controller {
	private Person person;
	
	public static void main(String[] args) {
		if (args.length > 0) {
			if (args[0].equals("test")) {
				//do nothing because we have junit
				System.out.println("why do you have args");
			}
		} else {
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