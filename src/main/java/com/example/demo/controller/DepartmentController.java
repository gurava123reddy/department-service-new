package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

@RestController
public class DepartmentController {
	
	private DepartmentService departmentService;

	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@PostMapping("/department-service")
	public ResponseEntity<String> saveDepartment(@RequestBody Department department){
		
		Department saveDepartment = departmentService.saveDepartment(department);
		return new ResponseEntity<>("Department saved successfully with Department No : "+saveDepartment.getDeptNo(), HttpStatus.CREATED);
	}
	
	@GetMapping("/department-service")
	public ResponseEntity<String> getAllDepartments(){
		List<Department> departmentList = departmentService.getAllDepartments();
		return new ResponseEntity<>("Fetched all departments successfully",HttpStatus.OK);
		
	}
	
	@GetMapping("/department")
	public ResponseEntity<List<Department>> getDepartments(){
		List<Department> departmentList = departmentService.getAllDepartments();
		return new ResponseEntity<>(departmentList,HttpStatus.OK);
		
	}
	

}
