package com.theo.minimal_fashion;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
public class Torso extends Clothing{
	
	public void testMethod() {
		System.out.println("test method");
	}
	
	private String name;
	private String id;
	private int condition;
	private int daysWorn;
	private int temperatureRating;
	private Boolean layerable;
	private double styleRating;
	private String typeOfClothing;
	
	@Override
	public void setup(String name) {
		this.name = name;
		id = name;
		setId(id);
		setTypeOfClothing("Torso");
		daysWorn = 0;
		typeOfClothing = "Torso";
	}
	
	//Composite primary key: typeOfClothing, id
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*
	@Override
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id =id;
	}
	*/
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
	public int getTemperatureRating() {
		return temperatureRating;
	}
	public void setTemperatureRating(int temperatureRating) {
		this.temperatureRating = temperatureRating;
	}
	public Boolean getLayerable() {
		return layerable;
	}
	public void setLayerable(Boolean layerable) {
		this.layerable = layerable;
	}
	public double getStyleRating() {
		return styleRating;
	}
	public void setStyleRating(double d) {
		this.styleRating = d;
	}
	/*
	@Override
	public String getTypeOfClothing() {
		return typeOfClothing;
	}
	
	public void setTypeOfClothing(String typeOfClothing) {
		this.typeOfClothing = typeOfClothing;
	}
	*/
}
