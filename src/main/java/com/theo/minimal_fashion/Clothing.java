package com.theo.minimal_fashion;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public abstract class Clothing {
	private String id;
	private String typeOfClothing;
	
	//TODO: this is abstract instead of interface, I think that's fine but noted to cya
	public abstract void setup(String name);
	
	@DynamoDbPartitionKey
	public String getTypeOfClothing() {
		return typeOfClothing;
	}
	public void setTypeOfClothing(String typeOfClothing) {
		this.typeOfClothing = typeOfClothing;
	}
	
	@DynamoDbSortKey
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id =id;
	}
}

/*
@DynamoDbBean
public interface Clothing {
	//TODO: this is abstract instead of interface, I think that's fine but noted to cya
	public void setup(String name);
	
	@DynamoDbPartitionKey
	public String getTypeOfClothing();
	
	@DynamoDbSortKey
	public String getId();
}
*/