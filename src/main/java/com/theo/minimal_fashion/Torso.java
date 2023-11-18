package com.theo.minimal_fashion;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class Torso extends Clothing{
	private Boolean layerable;
	
	@Override
	public void setup(String name) {
		setName(name);
		setId(name);
		setTypeOfClothing("Torso");
		setDaysWorn(0);
	}
	
	public Boolean getLayerable() {
		return layerable;
	}
	public void setLayerable(Boolean layerable) {
		this.layerable = layerable;
	}
	
	public void testMethod() {
		System.out.println("test method");
	}
}
