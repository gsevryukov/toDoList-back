package com.myDemoProject.toDoList.controller;

import com.myDemoProject.toDoList.model.entities.TaskCategory;
import com.myDemoProject.toDoList.services.implementations.TaskCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriesController {

    @Autowired
    private TaskCategoryServiceImpl taskCategoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<TaskCategory>> readAll() {

        final List<TaskCategory> result = taskCategoryService.readAll();
        return result != null && !result.isEmpty()
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/categories/{id}")
    public ResponseEntity<TaskCategory> read(@PathVariable(name = "id") Long id) {
        final TaskCategory taskCategory = taskCategoryService.read(id);

        return taskCategory != null
                ? new ResponseEntity<>(taskCategory, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/categories")
    public ResponseEntity<?> create(@RequestBody TaskCategory taskCategory) {
        taskCategoryService.create(taskCategory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/categories/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody TaskCategory taskCategory) {
        final boolean updated = taskCategoryService.update(taskCategory, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/categories/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final boolean deleted = taskCategoryService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
