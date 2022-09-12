package fr.asys.starter.cleher.core.api.taskmanager.controller.rest;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.asys.starter.cleher.core.api.taskmanager.dto.TaskDto;
import fr.asys.starter.cleher.core.api.taskmanager.service.TaskUpdateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/tasks")
@Tag(name = "task-update", description = "Pour mettre à jour des tâches")
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
