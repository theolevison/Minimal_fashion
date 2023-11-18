package com.theo.minimal_fashion;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ResourceInUseException;

public class DynamoDBAbstraction {
	static final DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.create();
	static final TableSchema<Clothing> clothingTableSchema = TableSchema.fromBean(Clothing.class);
	static final DynamoDbTable<Clothing> clothingTable = enhancedClient.table("Clothing", clothingTableSchema);
	
	public DynamoDBAbstraction() {
		try {
			clothingTable.createTable();
			System.out.println("Created table");
		} catch (ResourceInUseException e) {
			//table already exists, consume error & proceed
		}
	}
	
	
	public Clothing get(String partitionKey, String sortKey) {
		//retrieve clothing
		try {
	        // If there is no matching item, GetItem does not return any data.
			//TODO: doesn't work because Clothing is abstract, so the AWS builder can't make one, I do feel that a relational database would be better, I'm not really using dynamo for it's purpose
			Clothing thing = clothingTable.getItem(Key.builder().partitionValue(partitionKey).sortValue(sortKey).build());
			//gets data from table and creates a new object of type Clothing. We want to intercept it, and create a type of Torso, Legs etc
			//TODO: why not just have multiple tables of different Classes?
			if (thing == null) {
				throw new Exception("Object does not exist in database");
			}
			return thing;
	    } catch (Exception e) {
	        System.err.println(e.getMessage());
	        System.exit(1);
	    }
		return null;
	}
	
	public void superGet(String partitionKey, String sortKey) {
		ProfileCredentialsProvider credentialsProvider = ProfileCredentialsProvider.create();
        Region region = Region.EU_WEST_2;
        DynamoDbClient ddb = DynamoDbClient.builder()
            .credentialsProvider(credentialsProvider)
            .region(region)
            .build();
		
		 HashMap<String,AttributeValue> keyToGet = new HashMap<>();
	        keyToGet.put("typeOfClothing", AttributeValue.builder()
	            .s(partitionKey)
	            .build());
	        keyToGet.put("id", AttributeValue.builder()
		            .s(sortKey)
		            .build());

	        GetItemRequest request = GetItemRequest.builder()
	            .key(keyToGet)
	            .tableName("Clothing")
	            .build();

	        try {
	            // If there is no matching item, GetItem does not return any data.
	            Map<String,AttributeValue> returnedItem = ddb.getItem(request).item();
	            if (returnedItem.isEmpty())
	                System.out.print("No item found with the key %s!\n");
	            else {
	                Set<String> keys = returnedItem.keySet();
	                System.out.println("Amazon DynamoDB table attributes: \n");
	                for (String key1 : keys) {
	                    System.out.format("%s: %s\n", key1, returnedItem.get(key1).toString());
	                    //TODO: make this create a torso object using the factory
	                }
	            }

	        } catch (DynamoDbException e) {
	            System.err.println(e.getMessage());
	            System.exit(1);
	        }
	        ddb.close();
	}
	
	public boolean put(Clothing object) {
		if (object.getClass().equals(Torso.class)) {
			clothingTable.putItem((Torso)object);
		}
		
		return true;
	}
	
	
}