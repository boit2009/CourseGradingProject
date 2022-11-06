package coursegradingproject.controller.dto;

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
public class ProjectGroupRequest {
    private String name;
    private List<Integer> studentIds;
    private Integer courseClassId;
}
