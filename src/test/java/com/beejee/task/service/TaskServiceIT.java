package com.beejee.task.service;

import com.beejee.task.BaseServiceIntegrationTest;
import com.beejee.task.model.Status;
import com.beejee.task.model.Task;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TaskServiceIT extends BaseServiceIntegrationTest {

    @Autowired
    private TaskService taskService;


    @Test
    public void createTest() {
        Task task = createTaskObj("Code review 1", "Follow Clean Code rules 1", Status.OPEN);
        taskService.create(task);
        Assert.assertNotNull(task);
        Assert.assertNotNull(task.getId());
        Assert.assertNotNull(task.getCreatedAt());
    }


    private Task createTaskObj(String subject, String body, Status status) {
        Task task = new Task();
        task.setSubject(subject);
        task.setBody(body);
        task.setStatus(status);
        return task;
    }
}
