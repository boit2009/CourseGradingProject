package coursegradingproject.business;

import coursegradingproject.client.entity.CourseClass;
import coursegradingproject.client.entity.ProjectGroup;
import coursegradingproject.client.entity.Student;
import coursegradingproject.client.repository.CourseClassRepository;
import coursegradingproject.client.repository.ProjectGroupRepository;
import coursegradingproject.client.repository.StudentRepository;
import coursegradingproject.controller.dto.ProjectGroupRequest;
import coursegradingproject.controller.dto.ProjectGroupResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProjectGroupManager {
    private final ProjectGroupRepository projectGroupRepository;
    private final StudentRepository studentRepository;
    private final CourseClassRepository courseClassRepository;


    public ProjectGroupResponse getProjectGroup(Integer projectGroupId) {
        Optional<ProjectGroup> projectGroupOptional = projectGroupRepository.findById(projectGroupId);
        if (projectGroupOptional.isEmpty()){
            throw new NoSuchElementException("There is no projectGroup with this ID");

        }
        ProjectGroup projectGroup = projectGroupOptional.get();

        return ProjectGroupResponse.builder()
                .name(projectGroup.getName())
                .students(projectGroup.getStudents())
                .courseClass(projectGroup.getCourseClass())
                .ProjectScore(projectGroup.getProjectScore())
                .build();

    }

    public ProjectGroupResponse addProjectGroup(ProjectGroupRequest projectGroupRequest) {
        Optional<CourseClass> courseClassOptional = courseClassRepository.findById(projectGroupRequest.getCourseClassId());
        if (courseClassOptional.isEmpty()){
            throw new NoSuchElementException("There is no course with this ID");
        }
        List<Integer> requestedStudentIds= projectGroupRequest.getStudentIds();
        if(requestedStudentIds.size()==0){
            throw new NoSuchElementException("There is no given student");
        }
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < requestedStudentIds.size(); i++) {
            Optional<Student> studentOptional = studentRepository.findById(requestedStudentIds.get(i));
            if (studentOptional.isEmpty()){
                throw new NoSuchElementException("The given id student does not exist" + requestedStudentIds.get(i).toString());
            }
            studentList.add(studentOptional.get());
        }
        ProjectGroup projectGroup = new ProjectGroup(projectGroupRequest.getName(),studentList,courseClassOptional.get());
        studentList.forEach(s->s.setProjectGroup(projectGroup));
        ProjectGroup projectGroupSaved = projectGroupRepository.save(projectGroup);

        projectGroupRepository.flush();
        return ProjectGroupResponse.builder()
                .ProjectScore(projectGroupSaved.getProjectScore())
                .courseClass(projectGroupSaved.getCourseClass())
                .students(projectGroupSaved.getStudents())
                .name(projectGroupSaved.getName())
                .build();



    }
}
