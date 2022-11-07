package coursegradingproject.controller.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Builder
public  class ProjectGroupScoreRequest {

    private double projectScore;
}
