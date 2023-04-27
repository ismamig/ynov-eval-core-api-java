package ynov.eval.core.api.taskmanager.controller.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ynov.eval.core.api.taskmanager.controller.rest.navigation.TaskControllerUrlConstants;
import ynov.eval.core.api.taskmanager.dto.TaskDto;
import ynov.eval.core.api.taskmanager.service.TaskCreateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(TaskControllerUrlConstants.BASE)
@Tag(name = "tasks", description = "Pour créer des tâches")
public class TaskCreateRestController {

    private final TaskCreateService taskCreateService;

    public TaskCreateRestController(TaskCreateService taskCreateService) {
        this.taskCreateService = taskCreateService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Créer des tâches", operationId = "createTask")
    public ResponseEntity<List<TaskDto>> createTask(@RequestBody final List<TaskDto> tasksToCreate) {

        final List<TaskDto> createdTasks = tasksToCreate
                .stream()
                .map(taskCreateService::execute)
                .collect(Collectors.toList());

        return ResponseEntity.ok(createdTasks);
    }
}
