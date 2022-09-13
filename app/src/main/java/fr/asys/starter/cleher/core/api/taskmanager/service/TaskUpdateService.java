package fr.asys.starter.cleher.core.api.taskmanager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.asys.starter.cleher.core.api.taskmanager.dto.TaskDto;
import fr.asys.starter.cleher.core.api.taskmanager.mapper.TaskDtoMapper;
import fr.asys.starter.cleher.core.api.taskmanager.repository.TaskRepository;

@Service
public class TaskUpdateService {
    private final TaskRepository taskRepository;

    public TaskUpdateService(TaskRepository repository) {
        this.taskRepository = repository;
    }

    @Transactional
    public void execute(final int id, final TaskDto task) {
        task.setId(id);
        this.taskRepository.save(TaskDtoMapper.TaskDtoToTask(task));
    }
}
