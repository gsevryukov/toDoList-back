package com.myDemoProject.toDoList.services.interfaces;

import com.myDemoProject.toDoList.model.entities.Task;

import java.util.List;

public interface TaskService {

    void create(Task task);

    List<Task> readAll();

    Task read(Long id);

    boolean update(Task task, Long id);

    boolean delete(Long id);
}
