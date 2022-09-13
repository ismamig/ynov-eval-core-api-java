package fr.asys.starter.cleher.core.api.taskmanager.controller.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.asys.starter.cleher.core.api.taskmanager.controller.rest.navigation.TaskControllerUrlConstants;
import fr.asys.starter.cleher.core.api.taskmanager.dto.TaskDto;
import fr.asys.starter.cleher.core.api.taskmanager.service.TaskGetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(TaskControllerUrlConstants.BASE)
@Tag(name = "tasks", description = "Pour récupérer les tâches")
public class TaskGetRestController {
    private final TaskGetService taskGetService;

    public TaskGetRestController(TaskGetService taskGetService) {
        this.taskGetService = taskGetService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Récupérer les tâches existantes", operationId = "getTasks")
    public ResponseEntity<List<TaskDto>> getTasks() {
        return ResponseEntity.ok(taskGetService.execute());
    }
}
