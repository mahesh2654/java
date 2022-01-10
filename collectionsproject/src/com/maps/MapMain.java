package com.maps;

import java.util.HashMap;

public class MapMain {

	public static void main(String[] args) {

		HashMap<String, String> cities = new HashMap<String, String>();

		cities.put("MU", "Mumbai");
		cities.put("DE", "Delhi");
		cities.put("KO", "Kolkotta");
		cities.put("CH", "Chennai");
		cities.put("PU", "Pune");
		cities.put("HY", "hyderabad");
		cities.put("BH", "Bhubhaneswar");
System.out.println(cities);
		String city = cities.get("CH");

		if (city == null)
			System.out.println("City not found");
		else
			System.out.println(city);
		
		cities.remove("MU");
		
		System.out.println(cities.containsKey("MU"));

	}

}
