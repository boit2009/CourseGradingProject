package coursegradingproject.controller;

import coursegradingproject.business.StudentManager;
import coursegradingproject.controller.dto.StudentRequest;
import coursegradingproject.controller.dto.StudentResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class StudentController {
    private final StudentManager studentManager;
    @Operation
    @GetMapping("/asd")
    public String test(){
        return "test";
    }
    @PostMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public StudentResponse addStudent(@RequestBody StudentRequest studentDTO){
        return studentManager.saveStudent(studentDTO);

    }

}
