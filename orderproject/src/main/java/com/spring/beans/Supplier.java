package com.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class Supplier {
	private int supplierId = 111;
	private String supplierName = "All Item Suppliers";
	private String address = "Hyderabad";

	@Override
	public String toString() {
		return "SupplierId: " + supplierId + " SupplierName: " + supplierName + " Address=" + address;
	}

}
