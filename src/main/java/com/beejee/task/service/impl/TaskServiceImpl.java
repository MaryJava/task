package com.beejee.task.service.impl;

import com.beejee.task.model.Task;
import com.beejee.task.model.search.TaskSearchModel;
import com.beejee.task.repository.TaskRepository;
import com.beejee.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;


    @Transactional
    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Transactional
    @Override
    public Task update(Task task) {
        Task existingTask = findById(task.getId());
        // Do not update creation date
        task.setCreatedAt(existingTask.getCreatedAt());
        return taskRepository.save(task);
    }

    @Override
    public Task findById(Long id) {
        //return taskRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Not found task with id"));
        return taskRepository.findById(id).get();

    }

    @Override
    public List<Task> getTasks(TaskSearchModel searchModel) {
        return taskRepository.getTasks(searchModel);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Set<Task> createTasks(Set<Task> tasks) {
        List<Task> createdTasksList = taskRepository.saveAll(tasks);
        return new HashSet<>(createdTasksList);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
    }

    @Override
    public List<Task> findAllPageable(Pageable pageableRequest) {
        Pageable pageable = PageRequest.of(pageableRequest.getPageNumber(), 3, Sort.Direction.ASC, "createdAt");
        return taskRepository.findAll(pageable).getContent();
    }


    // TODO implement
    @Override
    public List<Task> sortListByParam() {
        return null;
    }


}
