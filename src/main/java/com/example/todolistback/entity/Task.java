package com.example.todolistback.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Task entity class
 */
@Entity
public class Task {

    @Id
    @Column(name="ID")
    private Long id;
    @Column(name="TITLE")
    private String title;
    @Column(name="DESCRIPTION")
    private String description;

    /**
     * Constructor
     * @param id Task id
     * @param title Task title
     * @param description Task description
     */
    public Task(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
