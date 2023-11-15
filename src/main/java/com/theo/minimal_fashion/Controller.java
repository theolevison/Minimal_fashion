package com.theo.minimal_fashion;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.ResourceInUseException;


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
			
			try {
				clothingTable.createTable();
				System.out.println("Created table");
			} catch (ResourceInUseException e) {
				//table already exists, consume error & proceed
			}
			
			
			//create object to put in table
			//TODO: use a factory method to bring back Torso, Legs etc
			TorsoClothingFactory tcf = new TorsoClothingFactory();
			Clothing tshirt = tcf.setupClothing("red tshirt");
			//all optional
			tshirt.setCondition(10);
			tshirt.setLayerable(true);
			tshirt.setStyleRating(0);
			tshirt.setTemperatureRating(5);
			
			clothingTable.putItem(tshirt);
			
			//retrieve clothing
			try {
	            // If there is no matching item, GetItem does not return any data.
				//TODO: doesn't work because Clothing is abstract, so the AWS builder can't make one, I do feel that a relational database would be better, I'm not really using dynamo for it's purpose
				Clothing thing = clothingTable.getItem(Key.builder().partitionValue("Torso").sortValue("red tshirt").build());
				//gets data from table and creates a new object of type Clothing. We want to intercept it, and create a type of Torso, Legs etc
				//TODO: why not just have multiple tables of different Classes?
				
				if (thing == null) {
					//key does not map to an item
				} else {
					System.out.println(thing.getName());
				}

	        } catch (Exception e) {
	            System.err.println(e.getMessage());
	            System.exit(1);
	        }
		}
		
	}
}