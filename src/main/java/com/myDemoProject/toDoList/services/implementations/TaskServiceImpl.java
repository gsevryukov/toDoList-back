package com.myDemoProject.toDoList.services.implementations;

import com.myDemoProject.toDoList.model.entities.Task;
import com.myDemoProject.toDoList.model.interfaces.TaskRepository;
import com.myDemoProject.toDoList.services.interfaces.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.myDemoProject.toDoList.model.constants.TaskStatuses.NewTask;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void create(Task task) {
        task.setStatus(NewTask);
        taskRepository.save(task);
    }

    @Override
    public List<Task> readAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task read(Long id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public boolean update(Task task, Long id) {
        if (taskRepository.existsById(id)) {
            task.setId(id);
            taskRepository.save(task);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
