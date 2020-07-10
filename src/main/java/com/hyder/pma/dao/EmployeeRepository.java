package com.hyder.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.hyder.pma.entities.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
