package fr.asys.starter.cleher.core.api.taskmanager.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.asys.starter.cleher.core.api.taskmanager.dto.TaskDto;
import fr.asys.starter.cleher.core.api.taskmanager.service.TaskCreateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/tasks")
@Tag(name = "task-creation", description = "Pour créer des tâches")
public class TaskCreateRestController {

    private final TaskCreateService taskCreateService;

    public TaskCreateRestController(TaskCreateService taskCreateService) {
        this.taskCreateService = taskCreateService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Créer des tâches", operationId = "createTask")
    public ResponseEntity<List<TaskDto>> createTask(@RequestBody final List<TaskDto> tasksToCreate) {

        final List<TaskDto> createdTasks = new ArrayList<>();

        for (TaskDto task : tasksToCreate) {
            createdTasks.add(taskCreateService.execute(task));
        }

        return ResponseEntity.ok(createdTasks);
    }
}
