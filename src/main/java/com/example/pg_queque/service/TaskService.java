package com.example.pg_queque.service;

import com.example.pg_queque.dto.model.TaskDto;

import java.util.List;

public interface TaskService {

    TaskDto findById(Long id);
    List<TaskDto> findAll();
    TaskDto createTask();
    TaskDto getTask();
    TaskDto getErrorTask();
    TaskDto save(TaskDto task);
    void delete(TaskDto task);
}
