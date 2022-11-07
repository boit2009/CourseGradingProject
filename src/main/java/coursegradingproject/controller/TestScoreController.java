package coursegradingproject.controller;

import coursegradingproject.business.TestScoreManager;
import coursegradingproject.controller.dto.StudentResponse;
import coursegradingproject.controller.dto.TestScoreRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class TestScoreController {
    private final TestScoreManager testScoreManager;

    @Operation
    @PostMapping(value = "/students/{studentID}/testscores", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public StudentResponse addTestScoreToStudentById(@RequestBody TestScoreRequest testScoreRequest, @PathVariable Integer studentID){
        return testScoreManager.addTestScoreToStudentById(testScoreRequest,studentID);
    }
    @Operation
    @PutMapping(value = "/students/{studentID}/testscores/{TestScoreID}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public StudentResponse addTestScoreToStudentById(@RequestBody TestScoreRequest testScoreRequest, @PathVariable Integer studentID, @PathVariable Integer TestScoreID){
        return testScoreManager.modifyTestScoreById(testScoreRequest,studentID,TestScoreID);
    }


}
