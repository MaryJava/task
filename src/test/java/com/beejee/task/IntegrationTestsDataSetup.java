package com.beejee.task;


import com.beejee.task.service.TaskService;
import com.beejee.task.setup.TaskDataWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@Lazy(value = false)
public class IntegrationTestsDataSetup {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskDataWriter taskDataWriter;

    @PostConstruct
    @Transactional
    public void insertInitialDataForTests() {
        taskDataWriter.insertData();
    }
}
