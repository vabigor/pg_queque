package com.example.pg_queque.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.Instant;
import java.util.Objects;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer status;
    private Integer attempt;
    private Instant delayedTo;
    private String errorText;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public Task setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Task setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public Task setAttempt(Integer attempt) {
        this.attempt = attempt;
        return this;
    }

    public Instant getDelayedTo() {
        return delayedTo;
    }

    public Task setDelayedTo(Instant delayedTo) {
        this.delayedTo = delayedTo;
        return this;
    }

    public String getErrorText() {
        return errorText;
    }

    public Task setErrorText(String errorText) {
        this.errorText = errorText;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(status, task.status) && Objects.equals(attempt, task.attempt) && Objects.equals(delayedTo, task.delayedTo) && Objects.equals(errorText, task.errorText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, attempt, delayedTo, errorText);
    }
}
