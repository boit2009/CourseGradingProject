package coursegradingproject.business;

import coursegradingproject.client.entity.CourseClass;
import coursegradingproject.client.entity.Student;
import coursegradingproject.client.repository.CourseClassRepository;
import coursegradingproject.client.repository.StudentRepository;
import coursegradingproject.controller.dto.StudentRequest;
import coursegradingproject.controller.dto.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll().stream().map(student -> {
             return StudentResponse.builder()
                    .id(student.getId()).courseClassId(student.getCourseClass().getId())
                    .name(student.getName())
                    .testScores(student.getTestScores())
                    .projectGroup(student.getProjectGroup()).build();
        }).collect(Collectors.toList());
    }
    public StudentResponse getStudentById(Integer id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isEmpty()){
            throw new RuntimeException("There is no student with this ID");
        }
        Student student = studentOptional.get();
        return StudentResponse.builder()
                .id(student.getId()).courseClassId(student.getCourseClass().getId())
                .name(student.getName())
                .testScores(student.getTestScores())
                .projectGroup(student.getProjectGroup()).build();




    }
}
