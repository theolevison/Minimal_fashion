package com.theo.minimal_fashion;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public abstract class Clothing {
	private String id;
	private String name;
	private String typeOfClothing;
	private int temperatureRating;
	private double styleRating;
	private int condition;
	private int daysWorn;
	
	public abstract void setup(String name);
	//TODO: will probably end up moving this client side anyway, using dynamo for style rules/attributes/personal profiles
	
	//Composite primary key: typeOfClothing, id
	
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getTemperatureRating() {
		return temperatureRating;
	}
	public void setTemperatureRating(int temperatureRating) {
		this.temperatureRating = temperatureRating;
	}
	
	public double getStyleRating() {
		return styleRating;
	}
	public void setStyleRating(double d) {
		this.styleRating = d;
	}
	
	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}
	
	public int getDaysWorn() {
		return daysWorn;
	}
	public void setDaysWorn(int daysWorn) {
		this.daysWorn = daysWorn;
	}
}