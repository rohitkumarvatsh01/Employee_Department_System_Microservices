package com.department.controller;

import com.department.model.Department;
import com.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create")
    public Department createNewRecord(@RequestBody Department department){
        return departmentService.createNewRecord(department);
    }

    @GetMapping("/get")
    public List<Department>getAllDepartment(){
        return departmentService.getAllRecord();
    }

    @GetMapping("/get/{id}")
    public Optional<Department>getRecordById(@PathVariable Long id){
        return departmentService.getRecordById(id);
    }

    @PutMapping("/update/{id}")
    public String updateRecord(@PathVariable Long id, @RequestBody Department department){
            return departmentService.updateRecord(id, department);
    }

    @DeleteMapping("/delete")
    public String deleteAllRecord(){
        return departmentService.deleteAllRecord();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOneRecord(@PathVariable Long id){
        return departmentService.deleteOneRecord(id);
    }
}
