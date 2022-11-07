package coursegradingproject.client.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private CourseClass courseClass;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private ProjectGroup projectGroup;
    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TestScore> testScores;

    public Student(String name, CourseClass courseClass) {
        this.name = name;
        this.courseClass = courseClass;
    }

    public Student(Integer id, String name, CourseClass courseClass, ProjectGroup projectGroup) {
        this.id = id;
        this.name = name;
        this.courseClass = courseClass;
        this.projectGroup = projectGroup;
    }
    public Student(String name, CourseClass courseClass, ProjectGroup projectGroup) {
        this.name = name;
        this.courseClass = courseClass;
        this.projectGroup = projectGroup;
    }
}
