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
        Task task = createTaskObj("Code review", "Follow Clean Code rules", Status.OPEN);
        taskService.create(task);
        Assert.assertNotNull(task);
        Assert.assertNotNull(task.getId());
        Assert.assertNotNull(task.getCreatedAt());
    }

    @Test
    public void updateTest() {
        Task task = createTaskObj("Bug fixing", "Fix all bugs", Status.IN_PROGRESS);
        taskService.create(task);
        flushAndClear();
        //update a task
        task.setSubject("New Bug fixing");
        task.setSubject("New Fix all bugs");
        Task updatedTask = taskService.update(task);
        Assert.assertNotNull(updatedTask);
        flushAndClear();
        Assert.assertEquals("New Bug fixing", updatedTask.getSubject());
        Assert.assertEquals("New Fix all bugs", updatedTask.getSubject());
        Assert.assertEquals(Status.IN_PROGRESS, updatedTask.getStatus());
    }

    private Task createTaskObj(String subject, String body, Status status) {
        Task task = new Task();
        task.setSubject(subject);
        task.setBody(body);
        task.setStatus(status);
        return task;
    }
}
