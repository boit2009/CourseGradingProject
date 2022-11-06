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
@Table(name = "project_group")
public class ProjectGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "projectGroup",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST})
    @JsonManagedReference
    private List<Student> students;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private CourseClass courseClass;
    private double ProjectScore;

    public ProjectGroup(String name, List<Student> students, CourseClass courseClass) {
        this.name = name;
        this.students = students;
        this.courseClass = courseClass;
    }
}
