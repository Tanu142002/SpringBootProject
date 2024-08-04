package com.tanu.service;

import java.util.List;

import com.tanu.model.Employee;

//public interface EmployeeService {
//
//	List<Employee> get();
//
//	Employee get(int id);
//
//	void save(Employee employee);
//
//	void delete(int id);
//}



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface EmployeeService {
    List<Employee> get();
    Employee get(int id);
    void save(Employee employee);
    void delete(int id);
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findAll(Sort sort);
}

