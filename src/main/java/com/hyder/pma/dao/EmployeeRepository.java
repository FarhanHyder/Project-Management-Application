package com.hyder.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.hyder.pma.entities.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	@Override
	public List<Employee> findAll();

}
