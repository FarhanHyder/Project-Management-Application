package com.hyder.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.hyder.pma.entities.Project;

//using this we can do crud data into the database
public interface ProjectRepository extends CrudRepository<Project, Long>{
	
}
