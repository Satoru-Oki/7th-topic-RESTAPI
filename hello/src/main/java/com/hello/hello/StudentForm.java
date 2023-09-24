package com.hello.hello;

import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class StudentForm {
    @NotNull
    @Pattern("^[0-9]{6}$")
    private String studentId;

    @NotNull
    private String name;

    @NotNull
    private String className;

    @NotNull
    private int gender;

    @NotNull
    private LocalDate birthday;

    public StudentForm(String studentId, String name, String className, int gender, LocalDate birthday) {
        this.studentId = studentId;
        this.name = name;
        this.className = className;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public int getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;

    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

}
