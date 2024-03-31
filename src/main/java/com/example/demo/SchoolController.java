package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

   /* @PostMapping("/schools")
    public School create(
            @RequestBody School school
    ){
        return schoolRepository.save(school);

    }*/

    @PostMapping("/schools")
    public SchoolDto create(
            @RequestBody SchoolDto dto
    ){
        var school = toSchool(dto);

        schoolRepository.save(school);
        return dto;

    }

    private School toSchool(SchoolDto dto){
        return new School(dto.name());
    }


    /*@GetMapping("/schools")
    public List<School> findAll(){
        return schoolRepository.findAll();
    }

}*/

    private SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getName());
    }

    @GetMapping("/schools")
    public List<SchoolDto> findAll(){

        return schoolRepository.findAll()
                .stream()
                .map(this:: toSchoolDto)// A method reference
                .collect(Collectors.toList());
    }

}
