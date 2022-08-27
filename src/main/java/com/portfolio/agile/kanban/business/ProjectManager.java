package com.portfolio.agile.kanban.business;

import com.portfolio.agile.kanban.dataAccess.IProjectDal;
import com.portfolio.agile.kanban.entity.MyProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ProjectManager implements  IProjectService{

    @Autowired
    private IProjectDal projectDal;
    @Override
    public List<MyProject> getAllProject() throws ExecutionException, InterruptedException {
        return projectDal.getAllProject();
    }

    @Override
    public String createMyProject(MyProject myProject) throws ExecutionException, InterruptedException {
        return projectDal.createMyProject(myProject);
    }

    @Override
    public MyProject getById(String documentId) throws ExecutionException, InterruptedException {
        return projectDal.getById(documentId);
    }

    @Override
    public String updateMyProject(MyProject myProject) throws ExecutionException, InterruptedException {
        return projectDal.updateMyProject(myProject);
    }

    @Override
    public String deleteMyProject(String documentId) {
        return projectDal.deleteMyProject(documentId);
    }


}
