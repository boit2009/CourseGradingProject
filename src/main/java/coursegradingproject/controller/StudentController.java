package coursegradingproject.controller;

import coursegradingproject.business.StudentManager;
import coursegradingproject.controller.dto.StudentRequest;
import coursegradingproject.controller.dto.StudentRequestCreate;
import coursegradingproject.controller.dto.StudentResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<StudentResponse> getAllStudents(@RequestParam(required = false, defaultValue = "20") Integer limit,
                                                @RequestParam(required = false, defaultValue = "desc") String sort){
        return studentManager.getAllStudents(limit, sort);
    }
    @GetMapping("/students/{id}")
    public StudentResponse getStudentById(@PathVariable Integer id){
        return studentManager.getStudentById(id);
    }
    @PostMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public StudentResponse addStudent(@RequestBody StudentRequestCreate studentDTO){
        return studentManager.saveStudent(studentDTO);

    }
    @DeleteMapping("/students/{id}")
    public String removeStudentById(@PathVariable Integer id){
        return studentManager.removeStudentById(id);
    }

    @PutMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public StudentResponse modifyStudent(@RequestBody StudentRequest studentDTO, @PathVariable Integer id){
        return studentManager.modifyStudent(studentDTO,id);

    }

}
