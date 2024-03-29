package com.example.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class StudentProfile {

    @Setter
    @Getter
    @Id
    @GeneratedValue
    private Integer id;

    @Setter
    @Getter
    private String bio;

    public StudentProfile(Integer id, String bio) {
        this.id = id;
        this.bio = bio;
    }

    public StudentProfile(Integer id, String bio, Student student) {
        this.id = id;
        this.bio = bio;
        this.student = student;
    }

    public StudentProfile() {
    }

    @OneToOne
    @JoinColumn(
            name = "student_id"
    )

    private  Student student;

}
