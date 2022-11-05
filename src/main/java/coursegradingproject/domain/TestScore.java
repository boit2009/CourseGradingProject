package coursegradingproject.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class TestScore {
    private Integer id;
    private Student student;
    private double testScore;
}
