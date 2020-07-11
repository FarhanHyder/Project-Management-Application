package com.hyder.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hyder.pma.dao.EmployeeRepository;
import com.hyder.pma.dao.ProjectRepository;
import com.hyder.pma.dto.EmployeeProject;
import com.hyder.pma.entities.Employee;
import com.hyder.pma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		
		List<EmployeeProject> employeesProjectCount = empRepo.employeeProjects();
		model.addAttribute("employeesProjectCount", employeesProjectCount);
		
		return "main/home";
	}

}
