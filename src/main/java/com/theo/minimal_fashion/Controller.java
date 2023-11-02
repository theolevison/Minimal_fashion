package com.theo.minimal_fashion;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;


public class Controller {
	static final DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.create();
	static final TableSchema<Clothing> clothingTableSchema = TableSchema.fromBean(Clothing.class);
	static final DynamoDbTable<Clothing> clothingTable = enhancedClient.table("Clothing", clothingTableSchema);
	
	public static void main(String[] args) {
		if (args.length > 0) {
			if (args[0].equals("test")) {
				//do nothing because we have junit
				System.out.println("why do you have args");
			}
		} else {
			//do stuff
			System.out.println("started");
			
			//TODO: check if table already exists
			//clothingTable.createTable();
			
			//create object to put in table
			Torso tshirt = new Torso();
			tshirt.setId("red tshirt");
			tshirt.setCondition(0);
			tshirt.setDaysWorn(0);
			tshirt.setLayerable(true);
			tshirt.setStyleRating(0);
			tshirt.setTemperatureRating(5);
			tshirt.setName("red tshirt");
			System.out.println(tshirt.toString());
			clothingTable.putItem(tshirt);
			
			
			
			//retrieve clothing
			
			
			try {
	            // If there is no matching item, GetItem does not return any data.
				//TODO: solve problem of retrieving an abstract class from the table
				Clothing thing =  clothingTable.getItem(Key.builder().partitionValue("red tshirt").build());
				System.out.println(thing.getName());

	        } catch (Exception e) {
	            System.err.println(e.getMessage());
	            System.out.println("whoops");
	            System.exit(1);
	        }
		}
		
	}
}