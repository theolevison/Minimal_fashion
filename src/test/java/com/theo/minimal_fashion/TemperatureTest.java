package com.theo.minimal_fashion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;



public class TemperatureTest{
	@Test
	@DisplayName("5 + 5 = 10")
	void tshirtAndShorts() {
		TorsoClothingFactory tcf = new TorsoClothingFactory();
		Clothing tshirt = tcf.setupClothing("red tshirt");
		tshirt.setTemperatureRating(5);
		
		Outfit outfit1 = new Outfit(new Clothing[]{tshirt});
		assertEquals(10, outfit1.getTemperatureRating());
	}
}