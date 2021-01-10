package com.myDemoProject.toDoList.model.interfaces;

import com.myDemoProject.toDoList.model.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

