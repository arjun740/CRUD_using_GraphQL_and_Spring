package com.arjun.graphql.service.impl;

import com.arjun.graphql.model.Group;
import com.arjun.graphql.model.Student;
import com.arjun.graphql.service.IStudentService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentServiceImpl implements IStudentService {
    public List<Student> students = new ArrayList<>();
    AtomicInteger id = new AtomicInteger();
    @PostConstruct
    public void init(){
        students.add(new Student(id.incrementAndGet(),"Arjun",15, Group.II_GROUP,"8807124761"));
        students.add(new Student(id.incrementAndGet(),"Max",16, Group.III_GROUP,"8807124761"));
        students.add(new Student(id.incrementAndGet(),"Lewis",17, Group.V_GROUP,"8807124761"));
        students.add(new Student(id.incrementAndGet(),"Messi",18, Group.I_GROUP,"8807124761"));
        students.add(new Student(id.incrementAndGet(),"Nagarjun",12, Group.IV_GROUP,"8807124761"));
    }
    @Override
    public List<Student> findAllStudent() {
        return students;
    }
    @Override
    public Student findStudent(int id) {
        Student student = students.stream().filter(stu -> stu.id() == id ).findFirst().orElseThrow(() -> new IllegalArgumentException());
        return student;
    }

    @Override
    public Student createStudent(String name, Group group, int age, String phoneNumber) {
        Student student = new Student(id.incrementAndGet(),name,age,group,phoneNumber);
        students.add(student);
        return student;
    }

    @Override
    public String deleteStudent(int id) {
        Student student = students.stream().filter(stu -> stu.id() == id).findFirst().orElseThrow(() -> new IllegalArgumentException());
        students.remove(student);
        return "Student ID:"+student.id()+" is Deleted Successfully";
    }

    @Override
    public Student updateStudent(Student updatedStudent) {
        // Cannot update a Student Detail because of using Record
        return null;
    }


}
