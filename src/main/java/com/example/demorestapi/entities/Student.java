package com.example.demorestapi.entities;

public class Student {
    private String firstname, lastname, section, classteachername, studentgender, studentDOB;
    private int studentclass, studentrollnumber, studentid;

    public Student() {

    }

    public Student(int studentclass, int studentrollnumber, int studentid, String firstname, String lastname, String section, String classteachername, String studentgender, String studentDOB) {
        this.studentclass = studentclass;
        this.studentrollnumber = studentrollnumber;
        this.studentid = studentid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.section = section;
        this.classteachername = classteachername;
        this.studentgender = studentgender;
        this.studentDOB = studentDOB;
    }

    public int getStudentclass() {
        return studentclass;
    }

    public void setStudentclass(int studentclass) {
        this.studentclass = studentclass;
    }

    public int getStudentrollnumber() {
        return studentrollnumber;
    }

    public void setStudentrollnumber(int studentrollnumber) {
        this.studentrollnumber = studentrollnumber;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getClassteachername() {
        return classteachername;
    }

    public void setClassteachername(String classteachername) {
        this.classteachername = classteachername;
    }

    public String getStudentgender() {
        return studentgender;
    }

    public void setStudentgender(String studentgender) {
        this.studentgender = studentgender;
    }

    public String getStudentDOB() {
        return studentDOB;
    }

    public void setStudentDOB(String studentDOB) {
        this.studentDOB = studentDOB;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentclass=" + studentclass +
                "studentrollnumber" + studentrollnumber +
                "studentid" + studentid +
                "firstname" + firstname +
                "lastname" + lastname +
                "section" + section +
                "classteachername" + classteachername +
                "studentgender" + studentgender +
                "studentDOB" + studentDOB +
                '}';

    }

}
