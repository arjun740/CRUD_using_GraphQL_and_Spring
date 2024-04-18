package com.arjun.graphql.controller;

import com.arjun.graphql.model.Group;
import com.arjun.graphql.model.Student;
import com.arjun.graphql.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {

    private IStudentService studentService;

    @QueryMapping
    public List<Student> findAllStudent(){
        List<Student> students = studentService.findAllStudent();
        return students;
    }
    @QueryMapping
    public Student findOne(@Argument int id) {
        Student student = studentService.findStudent(id);
        return student;
    }

    @MutationMapping
    public Student createStudentDetail(@Argument String name, @Argument int age, @Argument Group group, @Argument String phoneNumber){
        Student student = studentService.createStudent(name,group,age,phoneNumber);
        return student;
    }
    @MutationMapping
    public String deleteStudentDetail(@Argument int id){
        return studentService.deleteStudent(id);
    }
    @MutationMapping
    public String   updateStudentDetail (@Argument Student student){
        System.out.println(student);
        return "Student Detail Updated Successfully";
    }
}
