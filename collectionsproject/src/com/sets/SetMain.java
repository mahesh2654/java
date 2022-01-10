package com.sets;

import java.util.*;

public class SetMain {
	public static void main(String[] args) {
		
		LinkedHashSet<String> hs = new LinkedHashSet<String>();

		
		
		hs.add("Delhi");
		hs.add("Hyderabad");
		hs.add("Chennai");
		hs.add("Kanpur");
		hs.add("Bhubhaneshwar");

		hs.add("Mumbai");

		hs.add("Kolkotta");
		hs.add("Kanpur");
		hs.add("Hyderabad");

		System.out.println(hs.size());

		for (String city : hs)
			System.out.println(city);

		System.out.println(hs.contains("Hyderabad"));
		
		hs.remove("chennai");
		
		
		System.out.println("===================================");
		
		System.out.println(Collections.min(hs));

	}

}
