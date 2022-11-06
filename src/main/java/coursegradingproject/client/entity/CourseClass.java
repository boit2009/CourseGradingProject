package coursegradingproject.client.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "course_class")
public class CourseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "courseClass",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Student> students;
    @OneToMany(mappedBy = "courseClass",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ProjectGroup> projectGroups;

}
