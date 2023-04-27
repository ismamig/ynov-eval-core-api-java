package ynov.eval.core.api.taskmanager.service;
import ynov.eval.core.api.taskmanager.repository.TaskRepository;
import ynov.eval.core.api.taskmanager.mapper.TaskMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ynov.eval.core.api.taskmanager.dto.TaskDto;
import ynov.eval.core.api.taskmanager.mapper.TaskDtoMapper;
import ynov.eval.core.api.taskmanager.model.Task;

@Service
public class TaskCreateService {
    private final TaskRepository taskRepository;
    private final TaskDtoMapper taskDtoMapper;
    private final TaskMapper taskMapper;

    public TaskCreateService(final TaskRepository repository, final TaskDtoMapper taskDtoMapper, final TaskMapper taskMapper) {
        this.taskRepository = repository;
        this.taskDtoMapper = taskDtoMapper;
        this.taskMapper = taskMapper;
    }

    @Transactional
    public TaskDto execute(final TaskDto taskDTO) {
        final Task taskToCreate = taskDtoMapper.map(taskDTO);
        final Task taskCreated = this.taskRepository.save(taskToCreate);
        return taskMapper.map(taskCreated);
    }

}
