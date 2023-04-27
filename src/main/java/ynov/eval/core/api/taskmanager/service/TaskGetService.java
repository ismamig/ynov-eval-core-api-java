package ynov.eval.core.api.taskmanager.service;

import java.util.List;

import ynov.eval.core.api.taskmanager.repository.TaskRepository;
import ynov.eval.core.api.taskmanager.mapper.TaskMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ynov.eval.core.api.taskmanager.dto.TaskDto;

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
