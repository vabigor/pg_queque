package com.example.pg_queque.service;

import com.example.pg_queque.dto.model.TaskDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class JobTask {

    private final TaskService service;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public JobTask(TaskService service) {
        this.service = service;
    }

    public void execute(TaskDto task){
        int delayedToMin = 1;
        task.setStatus(ThreadLocalRandom.current().nextInt(2, 5));
//        task.setStatus(3);
        switch (task.getStatus()){
            case 2 -> logger.info("Task {} completed", task.getId());
            case 3 -> {
                task.setDelayedTo(Instant.now().plus(delayedToMin, ChronoUnit.MINUTES));
                task.setErrorText("ERROR");
                if (task.getAttempt()>3){
                    service.delete(task);
                    logger.info("Task {} error more than 3. Task deleted", task.getId());
                    return;
                }
                logger.info("Task {} error", task.getId());
            }
            case 4 -> {
                task.setErrorText("FATAL ERROR");
                logger.info("Task {} fatal error", task.getId());
            }
        }
        service.save(task);
    }
}
