package com.hello.hello;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
@Validated
public class StudentsController {

    @GetMapping("/allOf")  //すべて取得
    public List<StudentForm> getStudents() {
        List<StudentForm> allOf = List.of(
                new StudentForm("300001", "suzuki", "java", "1", LocalDate.of(2015, 12, 11)),
                new StudentForm("300002", "tanaka", "javascript", "0", LocalDate.of(2003, 3, 21)),
                new StudentForm("300003", "sakai", "python", "1", LocalDate.of(1973, 7, 30)));
        return allOf;
    }

    @GetMapping("/{studentId}")   //パスパラメータで指定したIDを取得
    public StudentForm getStudents(@Validated @NotBlank @Pattern(regexp = "^[0-9]{6}$") @PathVariable String studentId) {
        StudentForm studentList = this.getStudents().stream()
                .filter(form -> form.getStudentId().equals(studentId))
                .findFirst()
                .orElse(null);
        return studentList;
    }

    @GetMapping()   //クエリパラメータで指定したnameを取得
    public String getStudentsName(@Validated @NotBlank @RequestParam(value = "name", required = false) String name) {
        StudentForm studentList = this.getStudents().stream()
                .filter(form -> form.getName().equals(name))
                .findFirst()
                .orElse(null);
        // クエリパラメータがnullの場合
        if (studentList == null) {
            return new String("入力された値は不適当です");
        }
        // クエリパラメータで指定されたnameが存在する場合
        else {
            return studentList.getName() + new String("さんようこそ！");
        }
    }

    @PostMapping("/{studentsId}")
    public ResponseEntity<AlterResponse> create(@RequestBody @Validated StudentForm
                                                        studentForm, UriComponentsBuilder uriComponentsBuilder) {
        //登録処理省略
        URI uri = uriComponentsBuilder
                .path("students/{studentId}")
                .buildAndExpand(1)
                .toUri();
        return ResponseEntity.created(uri).body(new AlterResponse("student successfully created"));
    }

    @PatchMapping("/{studentId}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("studentId") int id,
                                                      @RequestBody @Validated StudentForm form) {
        // 更新処理省略

        return ResponseEntity.ok(Map.of("message", "studentId successfully updated"));
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("studentId") int id) {
        // 削除処理省略
        return ResponseEntity.ok(Map.of("message", "studentId successfully deleted"));
    }
}
