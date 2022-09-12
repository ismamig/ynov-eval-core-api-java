package fr.asys.starter.cleher.core.api.taskmanager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.asys.starter.cleher.core.api.taskmanager.dto.TaskDto;
import fr.asys.starter.cleher.core.api.taskmanager.repository.TaskRepository;

@Service
public class TaskCreateService {
    private final TaskRepository taskRepository;

    public TaskCreateService(TaskRepository repository) {
        this.taskRepository = repository;
    }

    @Transactional
    public TaskDto execute(TaskDto taskDTO) {
        return this.taskRepository.save(taskDTO);
    }
}
