package com.arjun.graphql.service;

import com.arjun.graphql.model.Group;
import com.arjun.graphql.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAllStudent();
    Student findStudent(int id);

    Student createStudent(String name, Group group, int age, String phoneNumber);

    String deleteStudent(int id);
    Student updateStudent(Student student);
}
