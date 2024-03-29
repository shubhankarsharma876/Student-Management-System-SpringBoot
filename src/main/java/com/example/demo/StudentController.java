package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    private final StudentRepository studentRepository;


    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

/*    @PostMapping("/students")
    public Student post(@RequestBody Student student){
        Student save = studentRepository.save(student);
        return save;
    }*/

    // the above bunch of code is using simple requesting which is made replaced with DTO as in the below code

    @PostMapping("/students")
    public Student post(@RequestBody StudentDto dto){
        var student = toStudent(dto);
        Student save = studentRepository.save(student);
        return save;
    }

    private Student toStudent(StudentDto dto){
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);
        return student;
    }
    
    @GetMapping("/students")
    public List<Student> findAll(){
        List<Student> all = studentRepository.findAll();
        return all;
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentById(@PathVariable("student-id") Integer id ){
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentByName(
            @PathVariable("student-name") String name)
    {
        return studentRepository.findAllByFirstnameContaining(name);
    }


    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ){
        studentRepository.deleteById(id);
    }


}
