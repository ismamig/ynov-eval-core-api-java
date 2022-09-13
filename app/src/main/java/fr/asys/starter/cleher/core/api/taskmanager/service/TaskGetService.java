package fr.asys.starter.cleher.core.api.taskmanager.service;

import java.util.List;

import fr.asys.starter.cleher.core.api.taskmanager.mapper.TaskMapper;
import fr.asys.starter.cleher.core.api.taskmanager.model.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.asys.starter.cleher.core.api.taskmanager.dto.TaskDto;
import fr.asys.starter.cleher.core.api.taskmanager.mapper.TaskDtoMapper;
import fr.asys.starter.cleher.core.api.taskmanager.repository.TaskRepository;

@Service
public class TaskGetService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskGetService(final TaskRepository repository, final TaskMapper taskMapper) {
        this.taskRepository = repository;
        this.taskMapper = taskMapper;
    }

    @Transactional
    public List<TaskDto> execute() {
        return this.taskRepository.findAll().stream().map(taskMapper::map).toList();
    }
}
