package com.portfolio.agile.kanban.business;

import com.portfolio.agile.kanban.dataAccess.IProjectDal;
import com.portfolio.agile.kanban.entity.MyProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
