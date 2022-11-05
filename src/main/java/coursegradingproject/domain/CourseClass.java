package coursegradingproject.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class CourseClass {
    private Integer id;
    private String name;
    private List<Student> students;
    private List<ProjectGroup> projectGroups;

}
