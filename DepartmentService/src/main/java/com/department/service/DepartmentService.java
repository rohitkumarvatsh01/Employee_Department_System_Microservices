package com.department.service;

import com.department.model.Department;
import com.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createNewRecord(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllRecord() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getRecordById(Long id) {
        return departmentRepository.findById(id);
    }

    public String updateRecord(Long id, Department department) {
        Optional<Department> dep=departmentRepository.findById(id);

        if(dep.isPresent()){
            Department existDepartment=dep.get();
            existDepartment.setName(department.getName());
            departmentRepository.save(existDepartment);
            return "Department id"+" is Updated";
        }
        else{
            return "Department id"+" is Not Found";
        }
    }

    public String deleteAllRecord() {
        departmentRepository.deleteAll();
        return "All Record is Deleted";
    }

    public String deleteOneRecord(Long id) {
        departmentRepository.deleteById(id);
        return "Department id "+id+" is Deleted";
    }
}
