package com.theo.minimal_fashion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;



public class TemperatureTest{
	@Test
	@DisplayName("5 + 5 = 10")
	void tshirtAndShorts() {
		Torso tshirt1 = new Torso();
		Legs shorts = new Legs();
		tshirt1.setTemperatureRating(5);
		shorts.setTemperatureRating(5);
		
		Outfit outfit1 = new Outfit(new Torso[]{tshirt1}, new Legs[]{shorts});
		assertEquals(10, outfit1.getTemperatureRating());
	}
}