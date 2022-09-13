package fr.asys.starter.cleher.core.api.taskmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.asys.starter.cleher.core.api.taskmanager.dto.TaskDto;
import fr.asys.starter.cleher.core.api.taskmanager.mapper.TaskDtoMapper;
import fr.asys.starter.cleher.core.api.taskmanager.repository.TaskRepository;

@Service
public class TaskGetService {
    private final TaskRepository taskRepository;

    public TaskGetService(TaskRepository repository) {
        this.taskRepository = repository;
    }

    @Transactional
    public List<TaskDto> execute() {
        return this.taskRepository.findAll().stream().map(TaskDtoMapper::TasktoTaskDto).toList();
    }
}
