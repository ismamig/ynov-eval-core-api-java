package fr.asys.starter.cleher.core.api.taskmanager.service;

import fr.asys.common.springboot.service.core.BaseService;
import fr.asys.starter.cleher.core.api.taskmanager.mapper.TaskMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.asys.starter.cleher.core.api.taskmanager.dto.TaskDto;
import fr.asys.starter.cleher.core.api.taskmanager.mapper.TaskDtoMapper;
import fr.asys.starter.cleher.core.api.taskmanager.model.Task;
import fr.asys.starter.cleher.core.api.taskmanager.repository.TaskRepository;

@Service
public class TaskCreateService extends BaseService<TaskDto, TaskDto> {
    private final TaskRepository taskRepository;
    private final TaskDtoMapper taskDtoMapper;
    private final TaskMapper taskMapper;

    public TaskCreateService(final TaskRepository repository, final TaskDtoMapper taskDtoMapper, final TaskMapper taskMapper) {
        this.taskRepository = repository;
        this.taskDtoMapper = taskDtoMapper;
        this.taskMapper = taskMapper;
    }

    @Transactional
    @Override
    public TaskDto execute(final TaskDto taskDTO) {
        final Task taskToCreate = taskDtoMapper.map(taskDTO);
        final Task taskCreated = this.taskRepository.save(taskToCreate);
        return taskMapper.map(taskCreated);
    }

}
