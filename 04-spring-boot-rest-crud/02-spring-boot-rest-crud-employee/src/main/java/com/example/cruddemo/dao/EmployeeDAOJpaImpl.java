package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager em;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e", Employee.class);
        List<Employee> employees =  query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = em.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = em.merge(employee);
        return dbEmployee;
    }

    @Override
    public void delete(int id) {
        Employee dbEmployee = em.find(Employee.class, id);
        em.remove(dbEmployee);
    }
}
