package com.beejee.task.service.impl;

import com.beejee.task.model.Task;
import com.beejee.task.repository.TaskRepository;
import com.beejee.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;

//@Service
public class TaskServiceImplTest {

    //  @Autowired
    //  private TaskRepository taskRepository;

    // @Override
    public Task save(Task task) {
        //File file = new File("images/flower-png-30.png");
        File file = new File("C:\\Users\\Meri\\images\\flower-png-30.png");
        byte[] bFile = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        task.setImage(bFile);
        return null;

        // return taskRepository.save(task);
    }

    //@Override
   /* public Task saveTest(Task task) {
        return taskRepository.save(task);
    }*/
}
