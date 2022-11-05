package coursegradingproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
@Data
@AllArgsConstructor
public class ProjectGroup {
    private Integer id;
    private String name;
    private List<Student> students;
    private CourseClass courseClass;

}
