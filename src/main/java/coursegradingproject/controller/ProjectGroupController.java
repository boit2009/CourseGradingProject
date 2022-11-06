package coursegradingproject.controller;

import coursegradingproject.business.ProjectGroupManager;
import coursegradingproject.controller.dto.ProjectGroupRequest;
import coursegradingproject.controller.dto.ProjectGroupResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
public class ProjectGroupController {
    private final ProjectGroupManager projectGroupManager;
    @Operation
    @GetMapping("/projectgroups/{id}")
    public ProjectGroupResponse getProjectGroupById(@PathVariable Integer id){
        return projectGroupManager.getProjectGroup(id);

    }
    @PostMapping(value = "/projectgroups", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProjectGroupResponse addProjectgroup(@RequestBody ProjectGroupRequest projectGroupRequest){
        return projectGroupManager.addProjectGroup(projectGroupRequest);

    }

}
