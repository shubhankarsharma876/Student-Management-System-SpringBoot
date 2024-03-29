package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public School create(
            @RequestBody School school
    ){
        return schoolRepository.save(school);

    }


    @GetMapping("/schools")
    public List<School> findAll(){
        return schoolRepository.findAll();
    }

}
