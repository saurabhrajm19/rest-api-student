package com.example.demorestapi.controller;

import com.example.demorestapi.entities.Student;
import com.example.demorestapi.exceptions.CustomExceptions;
import com.example.demorestapi.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/student/individual")
    public ResponseEntity postStudent(@RequestBody Student student) {
        try {
            String returnedValue = studentService.storeSingleStudent(student);
            return new ResponseEntity(returnedValue, HttpStatus.OK);
        } catch (CustomExceptions ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/student/multiple")
    public ResponseEntity postMultipleStudent(@RequestBody Student[] students) {
        try {
            String returnedValue = studentService.storeMultipleStudent(students);
            return new ResponseEntity(returnedValue, HttpStatus.OK);
        } catch (CustomExceptions ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/student-details/{studentid}")
    public ResponseEntity getStudent(@PathVariable int studentid) {
        try {
            Student student = studentService.fetchStudent(studentid);
            return new ResponseEntity(student, HttpStatus.OK);
        } catch (CustomExceptions ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/student-details")
    public ResponseEntity getAllStudent() {
        try {
            List<Student> students = studentService.fetchAllStudent();
            return new ResponseEntity(students, HttpStatus.OK);
        } catch (CustomExceptions ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/student-details/{studentid}")
    public ResponseEntity deleteStudent(@PathVariable int studentid) {
        try {
            String returnedValue = studentService.deleteStudent(studentid);
            return new ResponseEntity(returnedValue, HttpStatus.OK);
        } catch (CustomExceptions ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/update/student-details/{studentid}")
    public ResponseEntity putStudent(@PathVariable int studentid) {
        try {
            String returnedValue = studentService.putStudent(studentid);
            return new ResponseEntity(returnedValue, HttpStatus.OK);
        } catch (CustomExceptions ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping(value = "/update/student-details/{studentid}")
    public ResponseEntity patchStudent(@PathVariable int studentid, @RequestBody String classteachername) {
        try {
            String returnedValue = studentService.patchStudent(studentid, classteachername);
            return new ResponseEntity(returnedValue, HttpStatus.OK);
        } catch (CustomExceptions ex) {
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }



}
