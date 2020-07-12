package com.hyder.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyder.pma.dao.EmployeeRepository;
import com.hyder.pma.dao.ProjectRepository;
import com.hyder.pma.dto.ChartData;
import com.hyder.pma.dto.EmployeeProject;
import com.hyder.pma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		
		Map<String, Object> map = new HashMap<>();
		
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		
		List<ChartData> projectData = proRepo.getProjectStatus();
		// convert projectData into json
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		model.addAttribute("projectStatusCount", jsonString);
		
		List<EmployeeProject> employeesProjectCount = empRepo.employeeProjects();
		model.addAttribute("employeesProjectCount", employeesProjectCount);
		
		return "main/home";
	}

}
