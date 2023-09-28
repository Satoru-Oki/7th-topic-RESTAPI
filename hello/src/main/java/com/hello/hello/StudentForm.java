package com.hello.hello;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public class StudentForm {
    @Pattern(regexp = "^[0-9]{6}$")
    @NotBlank
    private String studentId;

    @NotBlank
    private String name;

    @NotBlank
    private String className;

    @NotBlank
    private String gender;

    @NotNull
    private LocalDate birthday;

    public StudentForm(String studentId, String name, String className, String gender, LocalDate birthday) {
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

    public String getGender() {
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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

}
