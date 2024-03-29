package com.example.demo;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class School{


    @Id
    @GeneratedValue
    private Integer Id;

    private String name;

    public School() {
    }

    public School(Integer id, String name) {
        Id = id;
        this.name = name;
    }

    public School(Integer id, String name, List<Student> students) {
        Id = id;
        this.name = name;
        this.students = students;
    }

    @OneToMany(
            mappedBy = "school"
    )

    //The @JSONManageReference is used as the information is co-relates so the hibernate will try to recieve all the
    // information at a time. And will lead to infinite loop so we will use this on parent as well as on child level.
    @JsonManagedReference
    private List<Student> students;
 
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
