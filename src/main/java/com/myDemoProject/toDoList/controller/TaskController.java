package com.myDemoProject.toDoList.controller;

import com.myDemoProject.toDoList.model.entities.Task;
import com.myDemoProject.toDoList.services.implementations.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> readAll() {

        final List<Task> result = taskService.readAll();
        return result != null && !result.isEmpty()
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity<Task> read(@PathVariable(name = "id") Long id) {
        final Task task = taskService.read(id);

        return task != null
                ? new ResponseEntity<>(task, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/tasks")
    public ResponseEntity<?> create(@RequestBody Task task) {
        taskService.create(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/tasks/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Task task) {
        final boolean updated = taskService.update(task, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/tasks/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final boolean deleted = taskService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
