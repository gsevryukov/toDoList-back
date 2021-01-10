package com.myDemoProject.toDoList.model.interfaces;

import com.myDemoProject.toDoList.model.entities.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Long> {
}
