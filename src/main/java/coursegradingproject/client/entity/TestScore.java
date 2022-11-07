package coursegradingproject.client.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "test_score")
public class TestScore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER/*, cascade = {CascadeType.MERGE}*/)
    @JsonBackReference
    private Student student;
    private double testScore;

    public TestScore(Student student, double testScore) {
        this.student = student;
        this.testScore = testScore;
    }
}
