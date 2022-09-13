package fr.asys.starter.cleher.core.api.taskmanager.mapper;

import fr.asys.common.springboot.service.core.BaseMapper;
import fr.asys.starter.cleher.core.api.taskmanager.dto.TaskDto;
import fr.asys.starter.cleher.core.api.taskmanager.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper extends BaseMapper<Task, TaskDto> {

    @Override
    public TaskDto map(final Task task) {
        final TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTask(task.getTask());
        taskDto.setDone(task.isDone());
        return taskDto;
    }

}
