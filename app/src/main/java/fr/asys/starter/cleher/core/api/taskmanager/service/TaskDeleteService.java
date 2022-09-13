package fr.asys.starter.cleher.core.api.taskmanager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.asys.starter.cleher.core.api.taskmanager.repository.TaskRepository;

@Service
public class TaskDeleteService {
    private final TaskRepository taskRepository;

    public TaskDeleteService(TaskRepository repository) {
        this.taskRepository = repository;
    }

    @Transactional
    public void execute(final int id) {
        this.taskRepository.deleteById(id);
    }
}
