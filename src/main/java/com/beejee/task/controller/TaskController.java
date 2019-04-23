package com.beejee.task.controller;


import com.beejee.task.bean.TaskBean;
import com.beejee.task.bean.mapping.TaskMapperFacade;
import com.beejee.task.model.Task;
import com.beejee.task.model.search.TaskSearchModel;
import com.beejee.task.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Api(value = "Task Management System", description = "Operations pertaining to task in Task Management System.\n There are two users: user with 456 passwor and admin with 123 password.\n Admin has full access. User can only read data.")

public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskMapperFacade taskMapperFacade;

    @ApiOperation(value = "Add a Task")
    @PostMapping("")
    public TaskBean createTask(@ApiParam(value = "Create Task object", required = true) @RequestBody TaskBean taskBean) {
        Task task = taskService.create(taskMapperFacade.getTask(taskBean));
        return taskMapperFacade.getTaskBean(task);
    }

    @ApiOperation(value = "Add a Task with image")
    @PostMapping("/taskwithimage")
    public TaskBean createTaskWithImage(TaskBean taskBean) throws IOException {
        Task task = taskMapperFacade.getTaskWithImage(taskBean);
        Task createdTask = taskService.create(task);
        return taskMapperFacade.getTaskBean(createdTask);
    }

    @ApiOperation(value = "Update a Task specified id")
    @PutMapping("/{id}")
    public TaskBean updateTask(@ApiParam(value = "Update Task object", required = true) @RequestBody TaskBean taskBean,
                               @ApiParam(value = "Task Id to update Task object", required = true) @PathVariable Long id) {
        Task task = taskMapperFacade.getTask(taskBean);
        task.setId(id);
        Task updatedTask = taskService.update(task);
        return taskMapperFacade.getTaskBean(updatedTask);
    }

    @ApiOperation(value = "Delete a Task with specified id")
    @DeleteMapping("/{id}")
    public void deleteTask(@ApiParam(value = "Task Id to delete Task object", required = true) @PathVariable Long id) {
        taskService.delete(id);
    }


    @ApiOperation(value = "Get a single Task by it's id")
    @GetMapping("/{id}")
    public TaskBean getTaskById(@ApiParam(value = "Task Id to retrieve Task object", required = true) @PathVariable Long id) {
        Task task = taskService.findById(id);
        return taskMapperFacade.getTaskBean(task);
    }

    @ApiOperation(value = "View a list of available tasks", response = List.class)//++++++++++user
    @GetMapping("")
    public List<TaskBean> allTasks() {
        List<Task> allTasks = taskService.findAll();
        List<TaskBean> taskBeans = new ArrayList<>(allTasks.size());
        for (Task task : allTasks) {
            taskBeans.add(taskMapperFacade.getTaskBean(task));
        }
        return taskBeans;
    }

    @ApiOperation(value = "View a list of available tasks with pagination (page size is 3) ", response = List.class)
    @GetMapping("/listwithpagination")
    public List<TaskBean> allTasksList(Pageable pageable) {
        List<Task> tasks = taskService.findAllPageable(pageable);
        List<TaskBean> taskBeans = new ArrayList<>(tasks.size());
        for (Task task : tasks) {
            taskBeans.add(taskMapperFacade.getTaskBean(task));
        }
        return taskBeans;
    }

    @ApiOperation(value = "Search and Sort tasks via different params", response = List.class)
    @GetMapping("/searchBy")
    public List<TaskBean> serachByParams(TaskSearchModel searchModel) {
        List<Task> tasks = taskService.getTasks(searchModel);
        List<TaskBean> taskBeans = new ArrayList<>(tasks.size());
        for (Task task : tasks) {
            taskBeans.add(taskMapperFacade.getTaskBean(task));
        }
        return taskBeans;
    }

    @ApiOperation(value = "Sort tasks via specified param", response = List.class)
    @GetMapping("/sortBy")
    public List<TaskBean> sortByParams(String sortParam) {
        List<Task> tasks = taskService.sortListByParam(sortParam);
        List<TaskBean> taskBeans = new ArrayList<>(tasks.size());
        for (Task task : tasks) {
            taskBeans.add(taskMapperFacade.getTaskBean(task));
        }
        return taskBeans;
    }
}
