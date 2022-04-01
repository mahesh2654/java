package com.trg.boot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trg.boot.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	
}

