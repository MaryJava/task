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
        Task task1 = createTaskObj("Test subject 1", "Test body 1", Status.OPEN);
        taskService.create(task1);

        Task task2 = createTaskObj("Test subject 2", "Test body 2", Status.IN_PROGRESS);
        taskService.create(task2);
    }

    private Task createTaskObj(String subject, String body, Status status) {
        Task task = new Task();
        task.setSubject(subject);
        task.setBody(body);
        task.setStatus(status);
        return task;
    }
}
