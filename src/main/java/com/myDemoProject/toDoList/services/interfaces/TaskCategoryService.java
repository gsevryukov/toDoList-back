package com.myDemoProject.toDoList.services.interfaces;

import com.myDemoProject.toDoList.model.entities.TaskCategory;

import java.util.List;

public interface TaskCategoryService {

    void create(TaskCategory taskCategory);

    List<TaskCategory> readAll();

    TaskCategory read (Long id);

    boolean update(TaskCategory taskCategory, Long id);

    boolean delete(Long id);
}
