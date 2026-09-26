package com.example.tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tracker.exceptions.TaskException;
import com.example.tracker.model.Task;
import com.example.tracker.repository.TaskRepo;

@Service
public class TaskService {

    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Task createTask(Task task) throws TaskException {
        return taskRepo.addTask(task);
    }

    public List<Task> taskList() throws TaskException {
        return taskRepo.getTasks();
    }

    public List<Task> getAllDoneTasks(boolean isDone) throws TaskException {
        System.out.println(isDone);
        return taskRepo.findAllByIsDone(isDone);
    }

    public Task updateTask(int id, Task task) throws TaskException {
        return taskRepo.Update(id, task);
    }

    public Task updateStatus(int id) throws TaskException {
        return taskRepo.updateStatus(id);
    }

    public String delete(int id) throws TaskException {
        return taskRepo.deleteById(id);
    }

    public Task getById(int id) throws TaskException {
        return taskRepo.findById(id);
    }
}
