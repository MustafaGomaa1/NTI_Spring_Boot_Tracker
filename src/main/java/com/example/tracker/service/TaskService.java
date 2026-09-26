package com.example.tracker.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.tracker.exceptions.TaskException;
import com.example.tracker.model.Task;
import com.example.tracker.model.TaskPage;
import com.example.tracker.repository.TaskRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepo taskRepo;

    public Task getById(int id) {
        return taskRepo.findById(id).orElseThrow(() -> new TaskException("Task Not Found"));
    }

    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    public Task updateTask(int id, Task task) {
        Task t = taskRepo.findById(id).orElseThrow(() -> new TaskException("Task Not Found"));
        t.setTitle(task.getTitle());
        t.setDescription(task.getDescription());
        t.setDone(task.isDone());
        taskRepo.save(t);
        return t;
    }

    public Task updateTaskStatus(int id) {
        Task task = taskRepo.findById(id).orElseThrow(() -> new TaskException("Task Not Found"));
        task.setDone(!task.isDone());
        taskRepo.save(task);
        return task;
    }

    public TaskPage getAllTask(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Task> page = taskRepo.findAll(pageable);
        return TaskPage.builder()
                .tasks(page.getContent())
                .pageNum(page.getNumber())
                .pageSize(page.getSize())
                .build();
    }

    public TaskPage getAllTaskByDone(boolean isDone, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Task> page = taskRepo.findByIsDone(isDone, pageable);
        return TaskPage.builder()
                .tasks(page.getContent())
                .pageNum(page.getNumber())
                .pageSize(page.getSize())
                .build();
    }

    public String deleteTask(int id){
        taskRepo.delete(taskRepo.findById(id).orElseThrow(()-> new TaskException("Task Not Found")));
        return "Delete Task!";
    }
}
