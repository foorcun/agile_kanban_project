package com.portfolio.agile.kanban.restApi;

import com.portfolio.agile.kanban.business.IProjectService;
import com.portfolio.agile.kanban.entity.MyProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProjectController {
    @Autowired
    private IProjectService projectManager;

    @GetMapping("/getAllProject")
    public List<MyProject> getAllProject() throws InterruptedException, ExecutionException {
        return projectManager.getAllProject();
    }

    @PostMapping("/createProject")
    public String createMyProject(@RequestBody MyProject myProject)throws InterruptedException, ExecutionException{
        return projectManager.createMyProject(myProject);
    }
    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint() {
        return ResponseEntity.ok("kanban Test Get Endpoint is Working");
    }

}
