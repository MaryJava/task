package com.beejee.task.setup;

import com.beejee.task.model.Status;
import com.beejee.task.model.Task;
import com.beejee.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskDataWriter {

    @Autowired
    private TaskService taskService;

    public void insertData() {
    }

    private Task createTaskObj(String subject, String body, Status status) {
        Task task = new Task();
        task.setSubject(subject);
        task.setBody(body);
        task.setStatus(status);
        return task;
    }
}
