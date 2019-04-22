package com.beejee.task.service;

import com.beejee.task.model.Task;
import com.beejee.task.model.search.TaskSearchModel;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface TaskService {

    Task create(Task task);

    Task update(Task task);

    Task findById(Long id);

    List<Task> getTasks(TaskSearchModel searchModel);

    void delete(Long id);

    Set<Task> createTasks(Set<Task> tasks);

    List<Task> findAll();

    List<Task> findAllPageable(Pageable pageable);

}
