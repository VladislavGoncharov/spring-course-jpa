package com.vladgoncharov.spring.jpa.spring_jpa.controller;



import com.vladgoncharov.spring.jpa.spring_jpa.entity.Employee;
import com.vladgoncharov.spring.jpa.spring_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return  allEmployees;
    }


    @GetMapping("/employees/{id}")
    public Employee getEmployee (@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
//
//        if (employee==null){
//            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
//        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

//        Employee emp = employeeService.getEmployee(employee.getId());
//        if (emp==null){
//            throw new NoSuchEmployeeException("An employee with this ID does not exist");
//        }

        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){

        Employee employee = employeeService.getEmployee(id);

       /* if (employee==null){
            throw new NoSuchEmployeeException("No employee with ID "+ id);
        }else */employeeService.deleteEmployee(id);
        return "Employee with ID = "+id+" was delete";

    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> findAllByName(@PathVariable String name){
        List<Employee> employees = employeeService.findAllByName(name);

        return employees;

    }





}
