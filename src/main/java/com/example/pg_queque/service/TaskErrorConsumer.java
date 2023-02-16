package com.example.pg_queque.service;

import com.example.pg_queque.dto.model.TaskDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskErrorConsumer implements Runnable {

    private final TaskService service;
    private final JobTask jobTask;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public TaskErrorConsumer(TaskService service, JobTask jobTask) {
        this.service = service;
        this.jobTask = jobTask;
    }

    @Override
    public void run() {
        try {
            logger.info("Init task error delay 5000 ms");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true){
           try {
               TaskDto task = service.getErrorTask();
               if (task == null){
                   Thread.sleep(5000);
                   continue;
               }else{
                   jobTask.execute(task);
               }
           }catch (Throwable e){
               e.printStackTrace();
               logger.error("Global ex "+cutString(e.getMessage()));
               try {
                   Thread.sleep(10000);
               } catch (Throwable ignore){}
           }
        }
    }

    private String cutString(String str){
        if (str != null && str.length() > 100){
            return str.substring(99);
        }
        return str;
    }
}
