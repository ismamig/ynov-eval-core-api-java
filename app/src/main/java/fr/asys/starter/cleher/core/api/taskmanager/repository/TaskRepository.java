package fr.asys.starter.cleher.core.api.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import fr.asys.starter.cleher.core.api.taskmanager.dto.TaskDto;

@Repository
public interface TaskRepository extends JpaRepository<TaskDto, Integer> {
}
