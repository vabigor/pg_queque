package com.example.pg_queque.dao.query;

import com.example.pg_queque.dto.model.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

@Component
public class TaskRowMapper implements RowMapper<TaskDto> {

    @Autowired
    public TaskRowMapper() {
    }

    @Override
    public TaskDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TaskDto()
                .setId(rs.getLong("id"))
                .setStatus(rs.getInt("status"))
                .setAttempt(rs.getInt("attempt"))
//                .setDelayedTo(Instant.ofEpochSecond(rs.getTimestamp("delayed_to").getTime()))
                .setErrorText(rs.getString("error_text"));
    }
}
