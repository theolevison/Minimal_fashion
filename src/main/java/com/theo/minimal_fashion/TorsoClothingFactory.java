package com.theo.minimal_fashion;

public class TorsoClothingFactory extends ClothingFactory{

	@Override
	public Clothing createClothing() {
		return new Torso();
	}

}