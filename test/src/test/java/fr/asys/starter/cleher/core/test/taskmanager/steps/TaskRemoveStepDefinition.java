package fr.asys.starter.cleher.core.test.taskmanager.steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import fr.asys.starter.cleher.core.client.controllers.TaskCreationApi;
import fr.asys.starter.cleher.core.client.controllers.TaskDeletionApi;
import fr.asys.starter.cleher.core.client.controllers.TaskGetApi;
import fr.asys.starter.cleher.core.client.invoker.ApiException;
import fr.asys.starter.cleher.core.client.model.TaskDto;
import fr.asys.starter.cleher.core.test.taskmanager.steps.common.TaskManagerTestContext;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TaskRemoveStepDefinition {
    private final TaskManagerTestContext taskManagerTestContext;

    public TaskRemoveStepDefinition(TaskManagerTestContext taskManagerTestContext) {
        this.taskManagerTestContext = taskManagerTestContext;
    }

    @DataTableType
    public TaskDto taskDtoEntry(final Map<String, String> entry) {
        final TaskDto taskDto = new TaskDto();

        final boolean isDone = Boolean.parseBoolean(entry.get("done"));
        final String task = entry.get("task");

        taskDto.done(isDone);
        taskDto.task(task);

        return taskDto;
    }

    @Given("les taches suivantes sont présente dans le système")
    public void les_taches_suivantes_sont_presentes(final List<TaskDto> tasks) throws ApiException {
        final TaskCreationApi taskCreationApi = taskManagerTestContext.getTaskCreationApi();
        taskCreationApi.createTask(tasks);

        final TaskGetApi taskGetApi = taskManagerTestContext.getTaskGetApi();
        assertTrue(taskGetApi.getTasks().size() > 0);
    }

    @When("je fais appel au endpoint des tâches pour supprimer les taches")
    public void je_fais_appel_au_endpoint_pour_supprimer_les_taches() throws ApiException {
        final TaskDeletionApi taskDeletionApi = taskManagerTestContext.getTaskDeletionApi();
        final TaskGetApi taskGetApi = taskManagerTestContext.getTaskGetApi();

        for (final TaskDto task : taskGetApi.getTasks()) {
            taskDeletionApi.deleteTask(task.getId());
        }
    }

    @Then("la tache n'est pas présente dans le système")
    public void la_tache_est_pas_presente_dans_le_systeme() throws ApiException {
        final TaskGetApi taskGetApi = taskManagerTestContext.getTaskGetApi();
        assertFalse(
                taskGetApi.getTasks().stream().map(TaskDto::getTask).anyMatch("TESTREMOVE: une tache de test"::equals));
    }
}
