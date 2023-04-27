package ynov.eval.core.api.taskmanager.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ynov.eval.core.api.taskmanager.controller.rest.navigation.TaskControllerUrlConstants;
import ynov.eval.core.api.taskmanager.dto.TaskDto;
import ynov.eval.core.api.taskmanager.service.TaskUpdateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(TaskControllerUrlConstants.BASE)
@Tag(name = "tasks", description = "Pour mettre à jour des tâches")
public class TaskUpdateRestController {
    private final TaskUpdateService taskUpdateService;

    public TaskUpdateRestController(TaskUpdateService taskUpdateService) {
        this.taskUpdateService = taskUpdateService;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Mettre à jour des tâches", operationId = "updateTask")
    public ResponseEntity<TaskDto> updateTask(@PathVariable("id") int id, @RequestBody final TaskDto taskToUpdate) {
        taskUpdateService.execute(id, taskToUpdate);
        return ResponseEntity.ok(taskToUpdate);
    }
}
