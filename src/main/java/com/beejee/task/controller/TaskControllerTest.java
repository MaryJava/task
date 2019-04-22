package com.beejee.task.controller;


import com.beejee.task.model.Task;
import com.beejee.task.model.Status;
import com.beejee.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

//@RestController
//@RequestMapping("/api/tasks")
public class TaskControllerTest {

    @Autowired
    private TaskService taskService;

   /* @PostMapping("")
    public Task createUser(@RequestBody Task task) {
        return taskService.save(task);
    }*/


    @PostMapping("/aaa")
    //public Task fileUploads(@RequestParam("file") MultipartFile file, @RequestBody Task task) throws IOException {
    public Task fileUploads(@RequestParam("file") MultipartFile file) throws IOException {

        //BufferedImage.TYPE_INT_RGB
        Task task = new Task();
        task.setSubject("aa");
        task.setBody("aaaaaaaaaaa");
        task.setStatus(Status.OPEN);
        task.setImage(file.getBytes());

       // return taskService.saveTest(task);
        return null;
    }


   /* private File uploadFile(MultipartFile file, String uploadDirectory) throws IOException {
        String fileName = file.getName(); // full name aa.png
        Path path = Paths.get(uploadDirectory, fileName);
        Files.copy(file.getInputStream(), path);

        String extension = "png";
        String fileBaseName = fileName.substring(0, fileName.length() - extension.length() - 1);
        File file1 = new File(uploadDirectory, fileName, extension, fileBaseName);
        return file1;
    }*/


}
