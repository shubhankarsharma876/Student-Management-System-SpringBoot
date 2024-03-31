package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    /*private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;*/ // Instance of the mapper to connect it with the service layer

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


 /*   public StudentController(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }*/

/*    @PostMapping("/students")
    public Student post(@RequestBody Student student){
        Student save = studentRepository.save(student);
        return save;
    }*/

    // the above bunch of code is using simple requesting which is made replaced with DTO as in the below code

    /*@PostMapping("/students")
    public StudentResponseDto post(@RequestBody StudentDto dto){
        var student = toStudent(dto);
        var savedStudent = studentRepository.save(student);

        return toStudentRepositoryDto(savedStudent);
    }*/

    // THE ABOVE CODE OF LINES FROM 30 TO 35 IS UPDATED TO UTILIZE THIS THROUGH THE SERVICE LAYER.

    @PostMapping("/students")
    public StudentResponseDto saveStudent(@RequestBody StudentDto dto){
        /*var student = studentMapper.toStudent(dto); //Adding details
        var savedStudent = studentRepository.save(student); // Saving details //THIS WILL BE SHIFTED TO StudentService.

        return studentMapper.toStudentRepositoryDto(savedStudent); //Sending response*/

        return this.studentService.saveStudent(dto);
    }

    /* SHIFTING THE BELOW TWO FUNTION TO THE SERVICE LAYER OR THE SERVICE LAYER CLASS WHICH IS BY THE NAME STUDENTMAPPER. */

    /*private Student toStudent(StudentDto dto){
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);
        return student;
    }

    private StudentResponseDto toStudentRepositoryDto(Student student){

        return new StudentResponseDto(student.getFirstname(),
                student.getLastname(),
        student.getEmail());

    }*/
    
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
