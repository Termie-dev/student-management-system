package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // Makes this class serve REST endpoints
@RequestMapping(path="api/v1/student") // We want 8080/api/v1/student
public class StudentController {

    private final StudentService studentService;

    @Autowired // studentService above should be autoserviced for us into this constructor below. Called injection. Want to use as much as possible.
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping // Want to get something out of our server
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) { // Take request body and add it to a student
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudentById(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudentById(studentId);
    }

    @PutMapping(path="{studentId}")
    public void updateStudent(@PathVariable("studentId") long studentId, @RequestParam(required=false) String name, @RequestParam(required=false) String email) {
        studentService.updateStudent(studentId, name, email);
    }

}
