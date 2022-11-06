package coursegradingproject.business;

import coursegradingproject.client.entity.CourseClass;
import coursegradingproject.client.entity.Student;
import coursegradingproject.client.repository.CourseClassRepository;
import coursegradingproject.client.repository.StudentRepository;
import coursegradingproject.controller.dto.StudentRequest;
import coursegradingproject.controller.dto.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentManager {
    private final StudentRepository studentRepository;
    private final CourseClassRepository courseClassRepository;
    public StudentResponse saveStudent(StudentRequest studentDTO){
        Optional<CourseClass> courseClassOptional = courseClassRepository.findById(studentDTO.getCourseClassId());
        if (courseClassOptional.isEmpty()){
            throw new RuntimeException("There is no course with this ID");
        }

        Student student = new Student(studentDTO.getName(), courseClassOptional.get());
        Student studentSaved = studentRepository.save(student);
        return StudentResponse.builder()
                .id(studentSaved.getId()).courseClassId(studentSaved.getCourseClass().getId())
                .name(studentSaved.getName())
                .testScores(studentSaved.getTestScores())
                .projectGroup(studentSaved.getProjectGroup()).build();



    }
}
