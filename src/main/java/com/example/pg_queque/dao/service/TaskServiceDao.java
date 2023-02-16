package com.example.pg_queque.dao.service;

import com.example.pg_queque.dao.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskServiceDao {

    Optional<Task> findById(Long id);
    List<Task> findAll();
    Task save(Task task);
    void delete(Long id);
}
