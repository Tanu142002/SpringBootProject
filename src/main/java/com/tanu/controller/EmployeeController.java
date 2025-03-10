package com.tanu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tanu.model.Employee;
import com.tanu.service.EmployeeService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public Employee save(@RequestBody Employee employeeObj) {
		employeeService.save(employeeObj);
		return employeeObj;
	}

	@GetMapping("/employee")
	public List<Employee> get() {
		return employeeService.get();
	}

	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable int id) {
		Employee employeeObj = employeeService.get(id);
		if (employeeObj == null) {
			throw new RuntimeException("Employee not found for the Id:" + id);
		}
		return employeeObj;
	}

	@PutMapping("/employee")
	public Employee update(@RequestBody Employee employeeObj) {
		employeeService.save(employeeObj);
		return employeeObj;
	}

	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		employeeService.delete(id);
		return "Employee has been deleted with id:" + id;
	}

	@GetMapping("/employee/page")
	public Page<Employee> findAll(@RequestParam int page, @RequestParam int size) {
		return employeeService.findAll(PageRequest.of(page, size));
	}

	@GetMapping("/employee/sort")
	public List<Employee> findAll(@RequestParam String sortBy, @RequestParam String direction) {
		Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
		return employeeService.findAll(sort);
	}
}