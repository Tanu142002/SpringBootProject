package com.tanu.dao;

import java.util.List;
//
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//
import com.tanu.model.Employee;
//
//@Repository
//public class EmployeeDAOImpl implements EmployeeDAO {
//
//	@Autowired
//	private EntityManager entityManager;
//
//	@Override
//	public List<Employee> get() {
//		Session currentSession = entityManager.unwrap(Session.class);
//		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
//		List<Employee> list = query.getResultList();
//		return list;
//	}
//
//	@Override
//	public Employee get(int id) {
//		Session currentSession = entityManager.unwrap(Session.class);
//		Employee employeeObj = currentSession.get(Employee.class, id);
//		return employeeObj;
//	}
//
//	@Override
//	public void save(Employee employee) {
//		Session currentSession = entityManager.unwrap(Session.class);
//		currentSession.saveOrUpdate(employee);
//	}
//
//	@Override
//	public void delete(int id) {
//		Session currentSession = entityManager.unwrap(Session.class);
//		Employee employeeObj = currentSession.get(Employee.class, id);
//		currentSession.delete(employeeObj);
//	}
//
//}

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee employeeObj = currentSession.get(Employee.class, id);
        currentSession.delete(employeeObj);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        return (Page<Employee>) query.getResultList();
    }

    @Override
    public List<Employee> findAll(Sort sort) {
        Session currentSession = entityManager.unwrap(Session.class);
        String hql = "from Employee e order by " + sort.toString().replace(":", "");
        Query<Employee> query = currentSession.createQuery(hql, Employee.class);
        return query.getResultList();
    }
}
