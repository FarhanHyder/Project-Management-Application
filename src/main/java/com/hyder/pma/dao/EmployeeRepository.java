package com.hyder.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hyder.pma.dto.EmployeeProject;
import com.hyder.pma.entities.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery=true, value="select e.FIRST_NAME as firstName, e.LAST_NAME as lastName, count(pe.EMPLOYEE_ID) as projectCount " + 
			"from EMPLOYEE e left join PROJECT_EMPLOYEE pe on pe.EMPLOYEE_ID = e.EMPLOYEE_ID " + 
			"group by e.FIRST_NAME, e.LAST_NAME order by 3 desc")
	public List<EmployeeProject> employeeProjects();

}
