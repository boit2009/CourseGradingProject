package coursegradingproject.controller.dto;

import coursegradingproject.client.entity.Student;
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
public class ProjectGroupResponse {//todo kvesebb info
    private String name;
    private List<Student> students;
    private Integer courseClassId;
    private double ProjectScore;
}
