package com.example.demo;


//schoolId is added as the object is referring the entity
public record StudentDto(
        String firstname,
        String lastname,
        String email,
        Integer schoolId //send this name in the postman

) {


}
