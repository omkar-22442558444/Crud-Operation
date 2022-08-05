package com.example.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
