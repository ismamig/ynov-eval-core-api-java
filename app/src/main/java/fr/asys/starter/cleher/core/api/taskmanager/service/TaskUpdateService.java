package fr.asys.starter.cleher.core.api.taskmanager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.asys.starter.cleher.core.api.taskmanager.dto.TaskDto;
import fr.asys.starter.cleher.core.api.taskmanager.repository.TaskRepository;

@Service
public class TaskUpdateService {
    private final TaskRepository taskRepository;

    public TaskUpdateService(TaskRepository repository) {
        this.taskRepository = repository;
    }

    @Transactional
    public void execute(int id, TaskDto task) {
        task.setId(id);
        this.taskRepository.save(task);
    }
}
