package fr.asys.starter.cleher.core.api.taskmanager.mapper;

import fr.asys.starter.cleher.core.api.taskmanager.dto.TaskDto;
import fr.asys.starter.cleher.core.api.taskmanager.model.Task;

public class TaskDtoMapper {

    public static TaskDto TasktoTaskDto(Task task) {
        final TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTask(task.getTask());
        taskDto.setDone(task.isDone());
        return taskDto;
    }

    public static Task TaskDtoToTask(TaskDto taskDto) {
        final Task task = new Task();
        task.setId(taskDto.getId());
        task.setTask(taskDto.getTask());
        task.setDone(taskDto.isDone());
        return task;
    }

}
