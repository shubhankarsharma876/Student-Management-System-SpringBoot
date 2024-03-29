package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Integer> {

    //This kind of method naming convention is used by Spring Data JPA to automatically generate queries
    // based on the method name. So, behind the scenes, Spring Data JPA will generate a query to retrieve
    // all Student entities where the firstName column contains the provided substring.
    List<Student> findAllByFirstnameContaining(String firstName);
}
