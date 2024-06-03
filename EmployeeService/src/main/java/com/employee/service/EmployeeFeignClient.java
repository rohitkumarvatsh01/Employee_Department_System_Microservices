package com.employee.service;

import com.employee.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="EmployeeService")
public interface EmployeeFeignClient {

    @GetMapping("/employee/{id}")
    Employee getEmployeeById(@PathVariable Long id);
}
