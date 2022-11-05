package coursegradingproject.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private CourseClass courseClass;
    private ProjectGroup projectGroup;

}
