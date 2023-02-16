package com.example.pg_queque.controller;

import com.example.pg_queque.dto.model.TaskDto;
import com.example.pg_queque.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/task")
public class TaskController {

    private final TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<TaskDto> getAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskDto> get(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TaskDto> post(){
        return ResponseEntity.ok(service.createTask());
    }
}
