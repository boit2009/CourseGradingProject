package coursegradingproject.controller.dto;

import coursegradingproject.client.entity.ProjectGroup;
import coursegradingproject.client.entity.TestScore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Builder
public class StudentResponse {
    private Integer id;
    private String name;
    private Integer courseClassId;
    private ProjectGroup projectGroup;
    private List<TestScore> testScores;


}
