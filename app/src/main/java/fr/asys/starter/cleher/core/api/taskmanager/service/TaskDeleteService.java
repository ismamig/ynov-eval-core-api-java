package fr.asys.starter.cleher.core.api.taskmanager.service;

import fr.asys.common.springboot.service.core.BaseService;
import fr.asys.starter.cleher.core.api.taskmanager.dto.TaskDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.asys.starter.cleher.core.api.taskmanager.repository.TaskRepository;

@Service
public class TaskDeleteService extends BaseService<Integer, Void> {
    private final TaskRepository taskRepository;

    public TaskDeleteService(TaskRepository repository) {
        this.taskRepository = repository;
    }

    @Transactional
    @Override
    public Void execute(final Integer id) {
        this.taskRepository.deleteById(id);
        return null;
    }
}
