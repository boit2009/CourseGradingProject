package coursegradingproject.controller.dto;

import coursegradingproject.client.entity.Student;
import lombok.*;

@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Builder
public class TestScoreRequest {

    private Integer studentId;
    private double testScore;
}
