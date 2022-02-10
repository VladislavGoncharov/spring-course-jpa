package com.vladgoncharov.spring.jpa.spring_jpa.dao;






import com.vladgoncharov.spring.jpa.spring_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findAllByName(String name);
}
