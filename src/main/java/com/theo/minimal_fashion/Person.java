package com.theo.minimal_fashion;

import java.util.ArrayList;
import java.util.Collection;

import software.amazon.awssdk.enhanced.dynamodb.Key;

public class Person {
	private String name;
	private String id;
	private ArrayList<Key> clothingKeys = new ArrayList<Key>();
	
	public Person(String name) {
		this.name = name;
		id = name;
	}
	
	public void getStyleAttributes() {
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	
	public void addClothingKeys(Clothing clothing) {
		clothingKeys.add(Key.builder().partitionValue(clothing.getClass().getSimpleName()).sortValue(clothing.getId()).build());
	}
	public void addClothingKeys(Collection<Clothing> clothing) {
		clothing.forEach(c -> clothingKeys.add(Key.builder().partitionValue(c.getClass().getSimpleName()).sortValue(c.getId()).build()));
	}
	public ArrayList<Key> getClothingKeys(){
		return clothingKeys;
	}
}
