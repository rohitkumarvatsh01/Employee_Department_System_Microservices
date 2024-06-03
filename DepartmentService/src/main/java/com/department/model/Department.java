package com.department.model;

import jakarta.persistence.*;

@Entity
@Table(name="Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
