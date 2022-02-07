package com.trg.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trg.boot.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee,Integer>{

}
