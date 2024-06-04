package com.department.service;

import com.department.model.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="DepartmentService")
public interface DepartmentFeignClient {

    @GetMapping("/department/{id}")
    Department getDepartmentById(@PathVariable Long id);
}
