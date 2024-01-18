package com.example.Employeemanagmentsystem.Service;

import java.util.List;

import com.example.Employeemanagmentsystem.Entity.Employee;

public interface EmployeeService {
	

	public List<Employee>getAllEmployee();
	
	Employee saveEmployee(Employee employee);
	
	Employee getEmployeeById(Long id);

	Employee updateEmployee(Employee employee);
	
	void deleteEmployeeById(Long id);


}
