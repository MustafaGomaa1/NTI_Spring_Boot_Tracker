package com.example.tracker.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.tracker.exceptions.TaskException;
import com.example.tracker.model.Task;

@Component
public class TaskRepo {

    private List<Task> tasks;
    private int tasksSize;
    @Value("${app.max-length}")
    private int taskLim;

    public TaskRepo() {
        tasks = new ArrayList<>();
        tasksSize = tasks.size();
    }

    public Task addTask(Task task) {
        if (tasksSize < taskLim) {
            tasksSize++;
            task.setTaskTime(LocalDate.now());
            tasks.add(task);
            return task;
        }
        throw new TaskException("Can't Add Task");
    }

    public Task findById(int id) {
        return tasks.stream().filter(task -> task.getId().equals(Integer.valueOf(id))).findFirst().get();
    }

    // public List<Task> getTasks(int pageSize, int PageNum) {
    // return tasks.subList(PageNum * 1, PageNum * pageSize);
    // }
    public List<Task> getTasks() {
        return tasks;
    }

    public String deleteById(int id) {
        tasks.remove(findById(id));
        return "Deleted !";
    }

    public List<Task> findAllByIsDone(boolean isDone) {
        System.out.println(isDone);
        return tasks.stream().filter(task -> task.isDone() == isDone).toList();
    }

    public Task Update(int id, Task task) {
        if (id > tasksSize)
            throw new TaskException("Task Not Found");
        Task task2 = findById(id);
        task2.setDone(task.isDone());
        task2.setDescription(task.getDescription());
        task2.setTitle(task.getTitle());
        return task2;
    }

    public Task updateStatus(int id) {
        if (id > tasksSize)
            throw new TaskException("Task Not Found");
        Task t = findById(id);
        t.setDone(true);
        return t;
    }
}
