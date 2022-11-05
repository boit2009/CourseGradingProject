package coursegradingproject.domain;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private CourseClass courseClass;
    private ProjectGroup projectGroup;
    private List<TestScore> testScores;

}
