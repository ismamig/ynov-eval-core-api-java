package ynov.eval.core.api.taskmanager.mapper;

import ynov.eval.core.api.taskmanager.dto.TaskDto;
import ynov.eval.core.api.taskmanager.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoMapper {

    public Task map(final TaskDto taskDto) {
        final Task task = new Task();
        task.setId(taskDto.getId());
        task.setTask(taskDto.getTask());
        task.setDone(taskDto.isDone());
        return task;
    }

}
