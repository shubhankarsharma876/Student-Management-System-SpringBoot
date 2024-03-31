package com.example.demo;


import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    //THE BELOW TWO METHODS ARE MADE COPY PASTED FROM THE STUDENTCONTROLLER FILE
    public Student toStudent(StudentDto dto){
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);
        return student;
    }

    public StudentResponseDto toStudentRepositoryDto(Student student){

        return new StudentResponseDto(student.getFirstname(),
                student.getLastname(),
                student.getEmail());

    }
}
