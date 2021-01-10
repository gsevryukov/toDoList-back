package com.myDemoProject.toDoList.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name = "description")
    @Getter
    @Setter
    private String description;

    @Column(name = "status")
    @Getter
    @Setter
    private String status;

    @Column(name = "est_date")
    @Getter
    @Setter
    private Integer estDate;

    @Column(name = "category_id")
    @Getter
    @Setter
    private Long categoryId;
}
