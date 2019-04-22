package com.beejee.task.bean.mapping;


import com.beejee.task.bean.TaskBean;
import com.beejee.task.model.Task;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Component
public class TaskMapperFacade {

    @Autowired
    private MapperFacade mapperFacade;

    public TaskBean getTaskBean(Task task) {
        return mapperFacade.map(task, TaskBean.class);
    }

    public Task getTask(TaskBean taskBean) {
        return mapperFacade.map(taskBean, Task.class);
    }

    public Task getTaskWithImage(TaskBean taskBean) throws IOException {
        MultipartFile file = taskBean.getFile();
        Task task = mapperFacade.map(taskBean, Task.class);
        task.setImage(file.getBytes());
        return task;
    }
}


