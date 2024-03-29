package com.example.demo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "T_STUDENT")
/*@Data*/
public class Student {

    @Setter
    @Getter
    @Id
    @GeneratedValue
    private Integer id;

    @Setter
    @Getter
    @Column(
            length = 20
    )
    private String firstname;

    @Getter
    @Setter
    private String lastname;

    @Getter
    @Setter
    @Column(unique = true)
    private String email;

    @Getter
    @Setter
    private int age;

    //For the table to table or entity to entity relationship
@OneToOne(
        mappedBy = "student",
        cascade = CascadeType.ALL
)
    private StudentProfile studentProfile;


    public Student() {
    }

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )

    //@JsonBackReference is used with the JsonManagedReference
    @JsonBackReference
    private School school;

    public Student(Integer id, String firstname, String lastname, String email, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
