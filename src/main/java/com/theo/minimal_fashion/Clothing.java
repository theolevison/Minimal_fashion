package com.theo.minimal_fashion;

public abstract class Clothing {
	private String name;
	private int id;
	private int condition;
	private int daysWorn;
	private int temperatureRating;
	private Boolean layerable;
	private double styleRating;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
}
