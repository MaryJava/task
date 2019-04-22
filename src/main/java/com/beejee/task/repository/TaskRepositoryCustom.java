package com.beejee.task.repository;

import com.beejee.task.model.Task;
import com.beejee.task.model.search.TaskSearchModel;

import java.util.List;

public interface TaskRepositoryCustom {

    List<Task> getTasks(TaskSearchModel searchModel);
}
