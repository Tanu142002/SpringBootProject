package com.tanu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tanu.dao.EmployeeDAO;
import com.tanu.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> get() {
        return employeeDAO.get();
    }

    @Override
    public Employee get(int id) {
        return employeeDAO.get(id);
    }

    @Override
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public void delete(int id) {
        employeeDAO.delete(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeDAO.findAll(pageable);
    }

    @Override
    public List<Employee> findAll(Sort sort) {
        return employeeDAO.findAll(sort);
    }
}
