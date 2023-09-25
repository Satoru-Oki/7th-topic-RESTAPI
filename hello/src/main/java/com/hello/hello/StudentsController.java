package com.hello.hello;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;


@RestController
@RequestMapping("/students")
@Validated

public class StudentsController {
    private StudentList studentList;

    public StudentsController() {
        this.studentList = new StudentList();
    }

    @GetMapping("/ofAll")  //すべて取得
    public StudentList getStudents() {
        return studentList;
    }

    @GetMapping()   //クエリパラメータで指定したIDを取得
    public StudentForm getStudents(@Validated @NotBlank @Pattern(regexp = "^[0-9]{6}$") @RequestParam(value = "studentId", required = false) String studentId) {
        if (studentId == null) {
            return null;
        }
        StudentForm studentForm = this.studentList.getStudentFormList().stream()
                .filter(form -> form.getStudentId().equals(studentId))
                .findFirst()
                .orElse(null);
        return studentForm;
    }

    @PostMapping("/creation/{studentId}")
    public ResponseEntity<AlterResponse> create(@RequestBody @Validated StudentForm studentForm, UriComponentsBuilder uriComponentsBuilder) {
        //登録処理省略
        URI url = UriComponentsBuilder.fromUriString("http//localhost:8080")
                .path("/creation/{studentId}")
                .buildAndExpand(1)
                .toUri();
        return ResponseEntity.created(url).body(new AlterResponse("student successfully created"));
    }

    @PatchMapping("/updates/{studentId}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("studentId") int id,
                                                      @RequestBody @Validated StudentForm form) {
        // 更新処理省略

        return ResponseEntity.ok(Map.of("message", "studentId successfully updated"));
    }

    @DeleteMapping("/deletes/{studentId}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("studentId") int id) {
        // 削除処理省略
        return ResponseEntity.ok(Map.of("message", "studentId successfully deleted"));
    }
}
