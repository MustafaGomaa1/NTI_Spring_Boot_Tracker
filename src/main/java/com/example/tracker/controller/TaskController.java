package com.example.tracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tracker.model.Task;
import com.example.tracker.model.TaskPage;
import com.example.tracker.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<TaskPage> tasks(@RequestParam(name = "complete", required = false) String isDone,
            @RequestParam(name = "pageNum", defaultValue = "0") int pageNum,
            @RequestParam(name = "pageSize", defaultValue = "3") int pageSize) {
        if (isDone == null)
            return ResponseEntity.status(HttpStatus.OK).body(taskService.getAllTask(pageNum, pageSize));
        else
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(taskService.getAllTaskByDone(Boolean.valueOf(isDone), pageNum, pageSize));

    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(task));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") int id, @RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.updateTask(id, task));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> updateStaus(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.updateTaskStatus(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.deleteTask(id));
    }

}
