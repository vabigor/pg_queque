package com.example.pg_queque.dto.model;

import java.time.Instant;

public class TaskDto {

    private Long id;
    private Integer status;
    private Integer attempt;
    private Instant delayedTo;
    private String errorText;

    public TaskDto() {
    }

    public Long getId() {
        return id;
    }

    public TaskDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public TaskDto setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public TaskDto setAttempt(Integer attempt) {
        this.attempt = attempt;
        return this;
    }

    public Instant getDelayedTo() {
        return delayedTo;
    }

    public TaskDto setDelayedTo(Instant delayedTo) {
        this.delayedTo = delayedTo;
        return this;
    }

    public String getErrorText() {
        return errorText;
    }

    public TaskDto setErrorText(String errorText) {
        this.errorText = errorText;
        return this;
    }
}
