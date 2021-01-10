package com.myDemoProject.toDoList.services.implementations;

import com.myDemoProject.toDoList.model.entities.TaskCategory;
import com.myDemoProject.toDoList.model.interfaces.TaskCategoryRepository;
import com.myDemoProject.toDoList.services.interfaces.TaskCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCategoryServiceImpl  implements TaskCategoryService {

    @Autowired
    private TaskCategoryRepository repository;

    @Override
    public void create(TaskCategory taskCategory) {
        repository.save(taskCategory);
    }

    @Override
    public List<TaskCategory> readAll() {
        return repository.findAll();
    }

    @Override
    public TaskCategory read(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public boolean update(TaskCategory taskCategory, Long id) {
        if(repository.existsById(id)) {
            taskCategory.setId(id);
            repository.save(taskCategory);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}
