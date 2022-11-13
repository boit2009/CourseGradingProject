package coursegradingproject.business;

import coursegradingproject.client.entity.CourseClass;
import coursegradingproject.client.entity.ProjectGroup;
import coursegradingproject.client.entity.Student;
import coursegradingproject.client.repository.CourseClassRepository;
import coursegradingproject.client.repository.ProjectGroupRepository;
import coursegradingproject.client.repository.StudentRepository;
import coursegradingproject.controller.dto.StudentRequest;
import coursegradingproject.controller.dto.StudentRequestCreate;
import coursegradingproject.controller.dto.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudentManager {
    private final StudentRepository studentRepository;
    private final CourseClassRepository courseClassRepository;
    private final ProjectGroupRepository projectGroupRepository;
    public StudentResponse saveStudent(StudentRequestCreate studentDTO){
        Optional<CourseClass> courseClassOptional = courseClassRepository.findById(studentDTO.getCourseClassId());
        if (courseClassOptional.isEmpty()){
            throw new NoSuchElementException("There is no course with this ID");
        }
       /* Optional<ProjectGroup> projectGroupOptional = projectGroupRepository.findById(studentDTO.getProjectGroupId());
        if (projectGroupOptional.isEmpty()){
            throw new NoSuchElementException("There is no projectgroup with this ID");
        }*/

        Student student = new Student(studentDTO.getName(), courseClassOptional.get()/*,projectGroupOptional.get()*/);
        Student studentSaved = studentRepository.save(student);
        return StudentResponse.builder()
                .id(studentSaved.getId()).courseClassId(studentSaved.getCourseClass().getId())
                .name(studentSaved.getName())
                .testScores(studentSaved.getTestScores())
                .projectGroupId(student.getProjectGroup() == null ? null : student.getProjectGroup().getId()).build();
    }
    public StudentResponse modifyStudent(StudentRequest studentDTO, Integer id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isEmpty()){
            throw new NoSuchElementException("There is no student with this ID!");
        }
        Optional<CourseClass> courseClassOptional = courseClassRepository.findById(studentDTO.getCourseClassId());
        if (courseClassOptional.isEmpty()){
            throw new NoSuchElementException("There is no course with this ID");
        }
        Optional<ProjectGroup> projectGroupOptional = projectGroupRepository.findById(studentDTO.getProjectGroupId());
        if (projectGroupOptional.isEmpty()){
            throw new NoSuchElementException("There is no projectgroup with this ID");
        }

        Student modifiedStudent = new Student(id,studentDTO.getName(), courseClassOptional.get(), projectGroupOptional.get());
        Student student = studentRepository.save(modifiedStudent);
        studentRepository.flush();

        return StudentResponse.builder()
                .id(student.getId()).courseClassId(student.getCourseClass().getId())
                .name(student.getName())
                .testScores(student.getTestScores())
                .projectGroupId(student.getProjectGroup() == null ? null : student.getProjectGroup().getId()).build();
    }

    public List<StudentResponse> getAllStudents(Integer limit, String sort/*@RequestParam(required = false, defaultValue = "20") Integer limit,
                                                @RequestParam(required = false, defaultValue = "desc") String sort*/) {
        if ( !sort.equalsIgnoreCase("desc") && !sort.equalsIgnoreCase("asc") ) {
            throw new IllegalArgumentException("Invalid sorting param! use 'asc' or 'desc' ");
        }
        var sortParam = sort.equalsIgnoreCase("asc") ?
                Sort.by(Sort.Direction.ASC, "name") : Sort.by(Sort.Direction.DESC, "name");


        return studentRepository.findAll(PageRequest.of(0,limit,sortParam))
                .stream().map(student -> {
                    return StudentResponse.builder()
                    .id(student.getId()).courseClassId(student.getCourseClass().getId())
                    .name(student.getName())
                    .testScores(student.getTestScores())
                    .projectGroupId(student.getProjectGroup() == null ? null : student.getProjectGroup().getId()).build();
        }).collect(Collectors.toList());
    }
    public StudentResponse getStudentById(Integer id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isEmpty()){
            throw new NoSuchElementException("There is no student with this ID!");
        }
        Student student = studentOptional.get();
        return StudentResponse.builder()
                .id(student.getId()).courseClassId(student.getCourseClass().getId())
                .name(student.getName())
                .testScores(student.getTestScores())
                .projectGroupId(student.getProjectGroup() == null ? null : student.getProjectGroup().getId()).build();




    }


    public String removeStudentById(Integer id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isEmpty()){
            throw new NoSuchElementException("There is no student with this ID!");
        }
        studentRepository.deleteById(id);

        return "user deleted succesfully";



    }
}
