package com.theo.minimal_fashion;

public class StyleAttribute {
	private String name;
	private String id;
	private float styleRating;
	private int daysWorn = 0;
	
	public StyleAttribute(String name) {
		this.name = name;
		id = name;
	}
	
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public float getStyleRating() {
		return styleRating;
	}
	public void setStyleRating(float styleRating) {
		this.styleRating = styleRating;
	}
	public int getDaysWorn() {
		return daysWorn;
	}
	public void setDaysWorn(int daysWorn) {
		this.daysWorn = daysWorn;
	}
}
