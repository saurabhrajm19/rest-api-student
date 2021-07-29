package com.example.demorestapi.service;

import com.example.demorestapi.entities.Student;
import com.example.demorestapi.exceptions.CustomExceptions;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    HashMap<Integer, Student> studentMap = new HashMap<>();

    public String deleteStudent(int studentid) throws CustomExceptions {
        if(studentMap.containsKey(studentid)){
            studentMap.remove(studentid);
            return "Deleted";
        }
        else {
            throw new CustomExceptions("Student with given id not found");
        }
    }

    public Student fetchStudent(int studentid) throws CustomExceptions {
        if(studentMap.containsKey(studentid)){
            return studentMap.get(studentid);
        }else {
            throw new CustomExceptions("Student not found");
        }
    }

    public List<Student> fetchAllStudent() throws CustomExceptions{
        Iterator it = studentMap.entrySet().iterator();
        List<Student> students=new ArrayList<Student>();

        if(studentMap.isEmpty()){
            throw new CustomExceptions("No Students found");
        }

        while (it.hasNext()) {
            Map.Entry mapElement = (Map.Entry)it.next();
            students.add((Student) mapElement.getValue());
        }
        return students;
    }

    public String storeSingleStudent(Student student)throws CustomExceptions {
        if(studentMap.containsKey(student.getStudentid())){
            throw new CustomExceptions("Student Already exists");
        }else {
            studentMap.put(student.getStudentid(), student);
            return "Saved";
        }
    }

    public String storeMultipleStudent(Student[] students)throws CustomExceptions{
        for(Student student : students){
            if(studentMap.containsKey(student.getStudentid())){
                throw new CustomExceptions("Student Already exists");
            }else {
                studentMap.put(student.getStudentid(), student);
            }
        }
        return "Saved";
    }

    public String putStudent(int studentid) throws CustomExceptions {
        if(studentMap.containsKey(studentid)){
            Student student = studentMap.get(studentid);
            student.setStudentclass(student.getStudentclass() + 1);
            studentMap.put(studentid, student);
            return "Updated";
        }
        else {
            throw new CustomExceptions("Student with given id not found");
        }
    }

    public String patchStudent(int studentid, String classteachername) throws CustomExceptions {
        if(studentMap.containsKey(studentid)){
            Student student = studentMap.get(studentid);
            student.setClassteachername(classteachername);
            studentMap.put(studentid, student);
            return "Updated class teacher name.";
        }
        else {
            throw new CustomExceptions("Student with given id not found");
        }
    }


}
