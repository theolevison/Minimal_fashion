package com.theo.minimal_fashion;

public abstract class ClothingFactory {
	public Clothing setupClothing(String name) {
		Clothing clothing = createClothing();
		clothing.setup(name);
		return clothing;
	}
	
	public abstract Clothing createClothing();
}