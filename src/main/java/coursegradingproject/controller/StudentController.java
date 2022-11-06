package coursegradingproject.controller;

import coursegradingproject.business.StudentManager;
import coursegradingproject.controller.dto.StudentRequest;
import coursegradingproject.controller.dto.StudentResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class StudentController {
    private final StudentManager studentManager;
    @Operation
    @GetMapping("/students")
    public List<StudentResponse> test(){
        return studentManager.getAllStudents();
    }
    @GetMapping("/students/{id}")
    public StudentResponse getStudentById(@PathVariable Integer id){
        return studentManager.getStudentById(id);
    }
    @PostMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public StudentResponse addStudent(@RequestBody StudentRequest studentDTO){
        return studentManager.saveStudent(studentDTO);

    }

}
