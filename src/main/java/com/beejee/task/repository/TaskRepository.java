package com.beejee.task.repository;

import com.beejee.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>, TaskRepositoryCustom {


}
