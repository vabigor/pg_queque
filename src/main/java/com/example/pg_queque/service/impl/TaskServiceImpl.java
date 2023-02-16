package com.example.pg_queque.service.impl;

import com.example.pg_queque.dao.entity.Task;
import com.example.pg_queque.dao.query.GettingTaskErrorQuery;
import com.example.pg_queque.dao.query.GettingTaskQuery;
import com.example.pg_queque.dao.service.TaskServiceDao;
import com.example.pg_queque.dto.mapper.TaskMapper;
import com.example.pg_queque.dto.model.TaskDto;
import com.example.pg_queque.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskServiceDao dao;
    private final GettingTaskQuery gettingTaskQuery;
    private final GettingTaskErrorQuery gettingTaskErrorQuery;

    @Autowired
    public TaskServiceImpl(TaskServiceDao dao,
                           GettingTaskQuery gettingTaskQuery,
                           GettingTaskErrorQuery gettingTaskErrorQuery) {
        this.dao = dao;
        this.gettingTaskQuery = gettingTaskQuery;
        this.gettingTaskErrorQuery = gettingTaskErrorQuery;
    }

    @Override
    public TaskDto findById(Long id) {
        return TaskMapper.entityToDto(dao.findById(id).orElseThrow(()->new RuntimeException(id.toString())));
    }

    @Override
    public List<TaskDto> findAll() {
        return TaskMapper.listEntityToDtoList(dao.findAll());
    }

    @Override
    public TaskDto createTask() {
        return TaskMapper.entityToDto(dao.save(new Task()));
    }

    @Override
    public TaskDto getTask() {
        return gettingTaskQuery.findObject();
    }

    @Override
    public TaskDto getErrorTask() {
        return gettingTaskErrorQuery.findObject();
    }

    @Override
    public TaskDto save(TaskDto task) {
        Task t = TaskMapper.dtoToEntity(task);
        return TaskMapper.entityToDto(dao.save(t));
    }

    @Override
    public void delete(TaskDto task) {
        dao.delete(task.getId());
    }
}
