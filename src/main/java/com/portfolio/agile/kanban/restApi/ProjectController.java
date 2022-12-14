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

    @GetMapping("/get")
    public MyProject getById(@RequestParam String documentId)throws InterruptedException, ExecutionException{
        return projectManager.getById(documentId);
    }

    @PostMapping("/createProject")
    public String createMyProject(@RequestBody MyProject myProject)throws InterruptedException, ExecutionException{
        return projectManager.createMyProject(myProject);
    }

    @PutMapping("/update")
    public String updateMyProject(@RequestBody MyProject myProject) throws ExecutionException, InterruptedException {
        return projectManager.updateMyProject(myProject);
    }

    @PutMapping("/delete")
    public String deleteMyProject(@RequestParam String documentId){
        return projectManager.deleteMyProject(documentId);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint() {
        return ResponseEntity.ok("kanban Test Get Endpoint is Working");
    }

}
