package com.student.management;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final StudentRepository studentRepository;

    public HelloController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Student Management System!";
    }

    @GetMapping("/students")
    public List<Student> getStudent() {
        return students;
    }

    private List<Student> students = new ArrayList<>();

    @PostMapping("/students") // create
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @PutMapping("/students/{id}") // Update
    public Student updateStudent(
            @PathVariable int id,
            @RequestBody Student updatedStudent) {

        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(updatedStudent.getName());
                student.setEmail(updatedStudent.getEmail());
                student.setCourse(updatedStudent.getCourse());

                return student;
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Student not found");
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return "Student deleted successfully";
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Student not found");
    }

    @GetMapping("/students/db-test")
    public List<Student> getStudentsFromDatabase() {
        return studentRepository.findAll();
    }
}