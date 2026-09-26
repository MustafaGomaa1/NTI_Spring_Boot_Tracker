package com.example.tracker.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tracker.model.Task;

public interface TaskRepo extends JpaRepository<Task, Integer> {

    Page<Task> findAll(Pageable pageable);

    Page<Task> findByIsDone(boolean isDone, Pageable pageable);

}
