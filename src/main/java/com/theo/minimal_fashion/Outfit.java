package com.theo.minimal_fashion;

import java.util.Arrays;

public class Outfit {
	private String name;
	private int temperatureRating;
	private Torso[] torsoClothing;
	private Legs[] legClothing;
	
	public Outfit(Torso[] torsoClothing, Legs[] legClothing){
		this.torsoClothing = torsoClothing;
		this.legClothing = legClothing;
		calculateTemperatureRating();
		name = "random outfit";
	}
	
	private void calculateTemperatureRating() {
		temperatureRating = Arrays.stream(torsoClothing).map(Clothing::getTemperatureRating).reduce(0, Integer::sum)
		+ Arrays.stream(legClothing).map(Clothing::getTemperatureRating).reduce(0, Integer::sum);
	}

	public int getTemperatureRating() {
		return temperatureRating;
	}
	
	public void rateOutfit(float newRating){
		for (Torso t : torsoClothing) {
			double currentRating = t.getStyleRating();
			//TODO: replace with something more advanced, #AI #Buzzwords
			double ratingDifference = Math.log(Math.pow((currentRating - newRating),2)+1);
			if (newRating < currentRating){
				t.setStyleRating(currentRating - ratingDifference);
			} else {
				t.setStyleRating(currentRating + ratingDifference);
			}
		}
	}

	public String getName() {
		return name;
	}
}