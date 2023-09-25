package com.hello.hello;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentList {

    private List<StudentForm> studentFormList;

    public StudentList() {
        this.studentFormList = new ArrayList<>();
        this.studentFormList.add(new StudentForm("381123", "suzuki", "java", "1", LocalDate.of(2015, 12, 11)));
        this.studentFormList.add(new StudentForm("381221", "tanaka", "javascript", "0", LocalDate.of(2003, 3, 21)));
        this.studentFormList.add(new StudentForm("372212", "sakai", "python", "1", LocalDate.of(1973, 7, 30)));
    }

    public List<StudentForm> getStudentFormList() {
        return this.studentFormList;
    }
}
