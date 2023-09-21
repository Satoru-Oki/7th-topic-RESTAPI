package com.hello.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsController {

    @GetMapping("/students")
    public List<Student> students() {
        List<Student> students = List.of(
                new Student("suzuki", "java", 1),
                new Student("tanaka", "javascript", 3),
                new Student("sakai", "python", 5));
        return students;
    }
}
