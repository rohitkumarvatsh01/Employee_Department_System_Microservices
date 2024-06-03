package com.employee.service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createNewRecord(Employee employee) {
        return employeeRepository.save(employee);
    }


    public List<Employee> getAllRecord() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getOneRecord(Long id) {
        return employeeRepository.findById(id);
    }

    public String updateRecord(Long id, Employee employee){
        Optional<Employee> emp=employeeRepository.findById(id);

        if(emp.isPresent()){
            Employee existEmp=emp.get();
            existEmp.setName(employee.getName());
            existEmp.setSalary((employee.getSalary()));
            existEmp.setDepartmentId((employee.getDepartmentId()));
            employeeRepository.save(existEmp);
            return "Employee "+id+" is Updated";
        }
        else{
            return "Employee "+id+" is not Present";
        }
    }

    public String deleteAllRecord() {
        employeeRepository.deleteAll();
        return "All Record is Deleted";
    }

    public String deleteOneRecord(Long id) {
        employeeRepository.deleteById(id);
        return "Employee "+id+" is Deleted";
    }
}
