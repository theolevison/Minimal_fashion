package com.theo.minimal_fashion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;



public class TemperatureTest{
	@Test
	@DisplayName("5 + 5 = 10")
	void tshirtAndShorts() {
		Clothing tshirt1 = new Clothing();
		Clothing shorts = new Clothing();
		tshirt1.setTemperatureRating(5);
		shorts.setTemperatureRating(5);
		
		Outfit outfit1 = new Outfit(new Clothing[]{shorts, tshirt1});
		assertEquals(10, outfit1.getTemperatureRating());
	}
}