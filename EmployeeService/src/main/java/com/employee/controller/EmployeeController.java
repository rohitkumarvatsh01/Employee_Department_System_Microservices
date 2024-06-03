package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee createNewRecord(@RequestBody Employee employee){
        return employeeService.createNewRecord(employee);
    }

    @GetMapping("/get")
    public List<Employee> getAllRecord(){
        return employeeService.getAllRecord();
    }

    @GetMapping("/get/{id}")
    public Optional<Employee> getOneRecord(@PathVariable Long id){
        return employeeService.getOneRecord(id);
    }

    @PutMapping("/update/{id}")
    public String updateRecord(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateRecord(id, employee);
    }

    @DeleteMapping("/delete")
    public String deleteAllRecord(){
        return employeeService.deleteAllRecord();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOneRecord(@PathVariable Long id){
        return employeeService.deleteOneRecord(id);
    }
}
