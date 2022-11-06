package coursegradingproject.client.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
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
}
