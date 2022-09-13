package fr.asys.starter.cleher.core.api.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.asys.starter.cleher.core.api.taskmanager.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
