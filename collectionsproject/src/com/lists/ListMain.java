package com.lists;

import java.util.ArrayList;
import java.util.Collections;

public class ListMain {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();

		list.add("Delhi");
		list.add("Hyderabad");
		list.add("Chennai");
		list.add("Kanpur");
		list.add("Bhubhaneshwar");

		list.add("Mumbai");

		list.add("Kolkotta");
		list.add("Kanpur");
		list.add("Hyderabad");
		
		Collections.sort(list);

		for (String city : list)
			System.out.println(city);
	
	
	}

}
