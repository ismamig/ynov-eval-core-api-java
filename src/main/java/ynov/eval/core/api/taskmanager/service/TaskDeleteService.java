package ynov.eval.core.api.taskmanager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ynov.eval.core.api.taskmanager.repository.TaskRepository;

@Service
public class TaskDeleteService {
    private final TaskRepository taskRepository;

    public TaskDeleteService(TaskRepository repository) {
        this.taskRepository = repository;
    }

    @Transactional
    public Void execute(final Integer id) {
        this.taskRepository.deleteById(id);
        return null;
    }
}
