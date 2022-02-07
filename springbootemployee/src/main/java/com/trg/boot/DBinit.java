package com.trg.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Service;

import com.trg.boot.entity.Employee;

import com.trg.boot.repo.EmployeeRepository;

@Service
public class DBinit implements CommandLineRunner {
	@Autowired
	EmployeeRepository repository;

	Logger logger = LoggerFactory.getLogger(DBinit.class);

	@Override
	public void run(String... args) throws Exception {

		repository.save(new Employee(100, "Suresh kumar", 15000, "M"));
		repository.save(new Employee(200, "Reyna Reddy", 15000, "F"));
		repository.save(new Employee(300, "Anil Jain", 11000, "M"));
		repository.save(new Employee(400, "Siddarth Reddy", 16000, "M"));
		repository.save(new Employee(500, "Akhila Kaur", 18000, "F"));
		repository.save(new Employee(600, "salman khan", 11000, "M"));
		repository.save(new Employee(700, "George Abraham", 25000, "M"));
		repository.save(new Employee(800, "Sirisha kumar", 13000, "F"));

		logger.info("Initial Employee objects added to the table");

	}

}
