package com.example.demo;

public class StudentService {
    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }


    public StudentResponseDto saveStudent(StudentDto dto){
        var student = studentMapper.toStudent(dto); //Adding details
        var savedStudent = studentRepository.save(student); // Saving details //THIS WILL BE SHIFTED TO StudentService.

        return studentMapper.toStudentRepositoryDto(savedStudent); //Sending response
    }
}
