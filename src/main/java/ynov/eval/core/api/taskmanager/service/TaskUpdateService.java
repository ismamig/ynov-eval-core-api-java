package ynov.eval.core.api.taskmanager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ynov.eval.core.api.taskmanager.mapper.TaskDtoMapper;
import ynov.eval.core.api.taskmanager.repository.TaskRepository;
import ynov.eval.core.api.taskmanager.dto.TaskDto;

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
