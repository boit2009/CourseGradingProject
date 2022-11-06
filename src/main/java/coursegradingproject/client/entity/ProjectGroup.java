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
@Table(name = "project_group")
public class ProjectGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "projectGroup",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Student> students;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private CourseClass courseClass;

}
