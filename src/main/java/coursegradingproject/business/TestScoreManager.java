package coursegradingproject.business;

import coursegradingproject.client.entity.Student;
import coursegradingproject.client.entity.TestScore;
import coursegradingproject.client.repository.StudentRepository;
import coursegradingproject.client.repository.TestScoreRepository;
import coursegradingproject.controller.dto.StudentResponse;
import coursegradingproject.controller.dto.TestScoreRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TestScoreManager {
    private final StudentRepository studentRepository;
    private final TestScoreRepository testScoreRepository;
    public StudentResponse addTestScoreToStudentById(TestScoreRequest testScoreRequest,  Integer studentID){
        Optional<Student> studentOptional = studentRepository.findById(studentID);
        if (studentOptional.isEmpty()){
            throw new NoSuchElementException("There is no student with this ID!");
        }
        Student student = studentOptional.get();
        TestScore testScore = new TestScore(student, testScoreRequest.getTestScore());
        TestScore testScoreSaved = testScoreRepository.save(testScore);
        testScoreRepository.flush();
        return StudentResponse.builder()
                .id(student.getId()).courseClassId(student.getCourseClass().getId())
                .name(student.getName())
                .testScores(student.getTestScores())
                .projectGroupId(student.getProjectGroup() == null ? null : student.getProjectGroup().getId()).build();


    }
    public StudentResponse modifyTestScoreById(TestScoreRequest testScoreRequest,  Integer studentID, Integer testID){
        Optional<Student> studentOptional = studentRepository.findById(studentID);
        if (studentOptional.isEmpty()){
            throw new NoSuchElementException("There is no student with this ID!");
        }
        Optional<TestScore> testScoreOptional = testScoreRepository.findById(testID);
        if (testScoreOptional.isEmpty()){
            throw new NoSuchElementException("There is no testScore with this ID!");
        }
        TestScore testScore = testScoreOptional.get();
        testScore.setTestScore(testScoreRequest.getTestScore());
        Student student = studentOptional.get();
        testScoreRepository.flush();
        return StudentResponse.builder()
                .id(student.getId()).courseClassId(student.getCourseClass().getId())
                .name(student.getName())
                .testScores(student.getTestScores())
                .projectGroupId(student.getProjectGroup() == null ? null : student.getProjectGroup().getId()).build();
    }



}
