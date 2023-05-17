package com.example.todolistback.controller;

import com.example.todolistback.entity.Task;
import com.example.todolistback.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    /**
     * Constructor
     * @param taskRepository Task repository
     */
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/task/{id}")
    Task one(@PathVariable Long id) {
        return this.taskRepository.findById(id).orElseThrow();
    }

    @GetMapping("/task")
    List<Task> all() {
        return this.taskRepository.findAll();
    }

    @PostMapping("/task")
    Task newTask(@RequestBody Task newTask) {
        return this.taskRepository.save(newTask);
    }

    @PutMapping("/task/{id}")
    Task replaceTask(@RequestBody Task newTask, @PathVariable Long id) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(newTask.getTitle());
                    task.setDescription(newTask.getDescription());
                    return taskRepository.save(task);
                })
                .orElseGet(() -> {
                    newTask.setId(id);
                    return taskRepository.save(newTask);
                });
    }

    @DeleteMapping("/task/{id}")
    void deleteTask(@PathVariable Long id) {
        this.taskRepository.deleteById(id);
    }

}
