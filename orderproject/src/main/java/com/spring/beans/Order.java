package com.spring.beans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Order {

	private int orderId;
	private LocalDate orderDate;

	@Autowired
	private Supplier supplier;

	@Autowired
	@Qualifier("item1")
	private Item item1;

	@Autowired
	@Qualifier("item2")
	private Item item2;

	public Order(int orderId, LocalDate orderDate) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderId: " + orderId + " OrderDate: " + orderDate + "\n  Supplier: " + supplier + "\n    Item1: " + item1
				+ "\n    Item2: " + item2;
	}

}
