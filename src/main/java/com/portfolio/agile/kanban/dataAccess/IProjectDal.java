package com.portfolio.agile.kanban.dataAccess;

import com.portfolio.agile.kanban.entity.MyProject;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IProjectDal {
    List<MyProject> getAllProject() throws ExecutionException, InterruptedException;

    String createMyProject(MyProject myProject) throws ExecutionException, InterruptedException;
}
