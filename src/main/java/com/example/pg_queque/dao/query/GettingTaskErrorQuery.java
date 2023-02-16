package com.example.pg_queque.dao.query;

import com.example.pg_queque.dto.model.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlFunction;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GettingTaskErrorQuery extends SqlFunction<TaskDto> {

    private final static String SQL = """
            with next_task as (
                select id from task
                where status = 3
                  and delayed_to < localtimestamp
                limit 1
                for update skip locked
            )
            update task
            set
                status = 1,
                attempt = attempt + 1,
                delayed_to = null,
                error_text = null
            from next_task
            where task.id = next_task.id
            returning task.id, task.status, task.attempt, task.delayed_to, task.error_text;
        """;
    private final TaskRowMapper rowMapper;

    @Autowired
    public GettingTaskErrorQuery(DataSource ds, TaskRowMapper rowMapper) {
        super(ds, SQL);
        this.rowMapper = rowMapper;
    }

    @Override
    protected TaskDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rowMapper.mapRow(rs, rowNum);
    }
}
