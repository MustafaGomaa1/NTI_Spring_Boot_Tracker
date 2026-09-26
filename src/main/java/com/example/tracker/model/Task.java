package com.example.tracker.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    private Integer id;
    private String title;
    private String description;
    private boolean isDone;
    private LocalDate taskTime;
}
