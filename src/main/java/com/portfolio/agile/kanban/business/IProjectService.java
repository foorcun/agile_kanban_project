package com.portfolio.agile.kanban.business;

import com.portfolio.agile.kanban.entity.MyProject;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IProjectService {
    List<MyProject> getAllProject() throws ExecutionException, InterruptedException;

    String createMyProject(MyProject myProject) throws ExecutionException, InterruptedException;

    MyProject getById(String documentId) throws ExecutionException, InterruptedException;

    String updateMyProject(MyProject myProject) throws ExecutionException, InterruptedException;

    String deleteMyProject(String documentId);
}
