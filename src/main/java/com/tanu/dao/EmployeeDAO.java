package com.tanu.dao;
//
import java.util.List;

import com.tanu.model.Employee;
//
//public interface EmployeeDAO {
//
//	List<Employee> get(); // will return employees
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

public interface EmployeeDAO {
    List<Employee> get();
    Employee get(int id);
    void save(Employee employee);
    void delete(int id);
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findAll(Sort sort);
}