package com.example.pg_queque.dto.mapper;

import com.example.pg_queque.dao.entity.Task;
import com.example.pg_queque.dto.model.TaskDto;

import java.util.List;
import java.util.stream.Collectors;

public class TaskMapper {

    public static Task dtoToEntity(TaskDto source) {
        return new Task()
                .setId(source.getId())
                .setStatus(source.getStatus())
                .setAttempt(source.getAttempt())
                .setDelayedTo(source.getDelayedTo())
                .setErrorText(source.getErrorText());
    }

    public static TaskDto entityToDto(Task source) {
        if (source == null){
            return null;
        }
        return entityToDto(new TaskDto(), source);
    }

    public static TaskDto entityToDto(TaskDto target, Task source) {
        return target
                .setId(source.getId())
                .setStatus(source.getStatus())
                .setAttempt(source.getAttempt())
                .setDelayedTo(source.getDelayedTo())
                .setErrorText(source.getErrorText());
    }

    public static List<TaskDto> listEntityToDtoList(List<Task> source) {
        if (source == null){
            return null;
        }
        return source.stream().map(TaskMapper::entityToDto).collect(Collectors.toList());
    }
}
