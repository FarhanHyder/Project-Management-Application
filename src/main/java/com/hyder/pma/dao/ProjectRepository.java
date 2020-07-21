package com.hyder.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.hyder.pma.dto.ChartData;
import com.hyder.pma.entities.Project;

//using this we can do crud data into the database
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long>{
	
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery=true, value="select stage as label, count(*) as value " + 
			"from project " + 
			"group by stage")
	public List<ChartData> getProjectStatus();

	public Project findByProjectId(long projectId);
}
