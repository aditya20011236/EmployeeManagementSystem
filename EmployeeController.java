package com.example.Employeemanagmentsystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Employeemanagmentsystem.Entity.Employee;
import com.example.Employeemanagmentsystem.Service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	// handler method to handle list employees and return mode and view
	
	@GetMapping("/employees")
	public String listEmployee(Model model) {
		List<Employee> Employeelist = employeeService.getAllEmployee();
		model.addAttribute("employees", Employeelist);
		return "employees";
		
	}
	@GetMapping("/addEmployee")
	public String createaddemployeeform(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "add_employee";
		
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
		
		
		
	}
	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model) {
		Employee employeeById = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employeeById);
		return "edit_employee";
		
	}
	@PostMapping("/employees/{id}")
	public String updateEmployee( @PathVariable Long id,@ModelAttribute("employee" )Employee employee, Model  model) {
		
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		employeeService.updateEmployee(existingEmployee);
		return "redirect:/employees";
		
	}
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees" ;
		
	}

		
}
	

