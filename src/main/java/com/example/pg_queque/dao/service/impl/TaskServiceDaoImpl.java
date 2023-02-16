package com.example.pg_queque.dao.service.impl;

import com.example.pg_queque.dao.entity.Task;
import com.example.pg_queque.dao.repository.TaskRepository;
import com.example.pg_queque.dao.service.TaskServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceDaoImpl implements TaskServiceDao {

    private final TaskRepository rep;

    @Autowired
    public TaskServiceDaoImpl(TaskRepository rep) {
        this.rep = rep;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Task> findById(Long id) {
        return rep.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> findAll() {
        return rep.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Task save(Task task) {
        return rep.save(task);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        rep.deleteById(id);
    }
}
