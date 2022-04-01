package com.trg.boot;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.trg.boot.entity.Employee;
import com.trg.boot.repo.EmployeeRepository;

@Service
public class DBInit  implements CommandLineRunner {
	
	@Autowired
	EmployeeRepository repo;

	Logger logger =LoggerFactory.getLogger(DBInit.class);
	
	@Override
	public void run(String... args) throws Exception {
		
		logger.info("DB Init started");
		
		repo.save(new Employee(100, "Suresh", 25000.0f, Date.valueOf("1998-10-21")));
		repo.save(new Employee(200, "Mahesh", 35000.0f, Date.valueOf("1999-05-15")));
		repo.save(new Employee(300, "Ganesh", 15000.0f, Date.valueOf("1995-08-06")));
		repo.save(new Employee(400, "Satish", 22000.0f, Date.valueOf("1987-02-10")));
		repo.save(new Employee(500, "Naresh", 17000.0f, Date.valueOf("1989-11-20")));
		repo.save(new Employee(600, "Ritesh", 46000.0f, Date.valueOf("1994-06-10")));
		repo.save(new Employee(700, "Bhavesh", 28000.0f, Date.valueOf("1995-07-18")));
		
		long count=repo.count();
		
		logger.info(count+"  objects added to employee table");
	}

}
