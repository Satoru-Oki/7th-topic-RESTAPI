package com.hello.hello;

public class Student {
    private String name;
    private String className;
    private int grade;

    public Student(String name, String className, int grade) {
        this.name = name;
        this.className = className;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public int getGrade() {
        return grade;
    }
}

