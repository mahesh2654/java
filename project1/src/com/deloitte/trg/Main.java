package com.deloitte.trg;

import com.deloitte.trg.data.Director;
import com.deloitte.trg.data.Employee;
import com.deloitte.trg.data.Manager;

public class Main {

	public static void main(String[] args) {

		
		Employee e;  // we can assign reference of any subclass object to this
		
		e= new Director(100, "Manish Kumar", 34000,"HDFC Bank");
		
		System.out.println("===============Manager================");
		e.display();
		
		
		e = new Manager(200, "Ganesh rao", 134000,"Microsoft");
		
		System.out.println("================Director============");
		e.display();
	}
}
