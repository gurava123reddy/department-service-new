package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="department7001", schema="public")
public class Department {
	
	@Id
	private int deptNo;
	
	private String deptName;
	private String deptLocation;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="deptNo", referencedColumnName="deptNo")
	List<Employee> empList;

	public Department() {}
	
	public Department(int deptNo, String deptName, String deptLocation) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.deptLocation = deptLocation;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLocation() {
		return deptLocation;
	}

	public void setDeptLocation(String deptLocation) {
		this.deptLocation = deptLocation;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
}
