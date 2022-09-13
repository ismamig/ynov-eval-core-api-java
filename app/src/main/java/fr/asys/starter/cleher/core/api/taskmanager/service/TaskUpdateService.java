package fr.asys.starter.cleher.core.api.taskmanager.service;

import fr.asys.starter.cleher.core.api.taskmanager.mapper.TaskMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.asys.starter.cleher.core.api.taskmanager.dto.TaskDto;
import fr.asys.starter.cleher.core.api.taskmanager.mapper.TaskDtoMapper;
import fr.asys.starter.cleher.core.api.taskmanager.repository.TaskRepository;

@Service
public class TaskUpdateService {
    private final TaskRepository taskRepository;
    private final TaskDtoMapper taskDtoMapper;

    public TaskUpdateService(TaskRepository repository, TaskDtoMapper taskDtoMapper) {
        this.taskRepository = repository;
        this.taskDtoMapper = taskDtoMapper;
    }

    @Transactional
    public void execute(final int id, final TaskDto task) {
        task.setId(id);
        this.taskRepository.save(taskDtoMapper.map(task));
    }
}
