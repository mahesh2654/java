package com.spring.beans;

public class Item {
	private int itemid;
	private String itemName;
	private float price;
	public Item(int itemid, String itemName, float price) {
		super();
		this.itemid = itemid;
		this.itemName = itemName;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Itemid: " + itemid + " ItemName: " + itemName + " Price: " + price;
	}
	
	

}
