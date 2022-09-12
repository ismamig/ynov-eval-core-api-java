package fr.asys.starter.cleher.core.test.taskmanager.steps;

import static org.junit.Assert.assertEquals;

import java.util.List;

import fr.asys.starter.cleher.core.client.controllers.TaskCreationApi;
import fr.asys.starter.cleher.core.client.controllers.TaskDeletionApi;
import fr.asys.starter.cleher.core.client.controllers.TaskGetApi;
import fr.asys.starter.cleher.core.client.invoker.ApiException;
import fr.asys.starter.cleher.core.client.model.TaskDto;
import fr.asys.starter.cleher.core.test.taskmanager.steps.common.TaskManagerTestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TaskCreateStepDefinition {

    private final TaskManagerTestContext taskManagerTestContext;

    public TaskCreateStepDefinition(TaskManagerTestContext taskManagerTestContext) {
        this.taskManagerTestContext = taskManagerTestContext;
    }

    @Given("je n'ai aucune tache dans le systeme")
    public void jai_aucune_taches() throws ApiException {
        final TaskDeletionApi taskDeletionApi = taskManagerTestContext.getTaskDeletionApi();
        final TaskGetApi taskGetApi = taskManagerTestContext.getTaskGetApi();

        for (final TaskDto task : taskGetApi.getTasks()) {
            taskDeletionApi.deleteTask(task.getId());
        }
        assertEquals(0, taskGetApi.getTasks().size());
    }

    @When("je fais appel au endpoint des tâches pour créer les tâches suivantes")
    public void je_fais_appel_au_endpoint_pour_creer_des_taches(final List<TaskDto> tasks) throws ApiException {
        final TaskCreationApi taskCreationApi = taskManagerTestContext.getTaskCreationApi();
        taskCreationApi.createTask(tasks);
    }

    @Then("j'ai une tache dans le systeme")
    public void jai_une_tache_dans_le_systeme() throws ApiException {
        final TaskGetApi taskGetApi = taskManagerTestContext.getTaskGetApi();
        assertEquals(1, taskGetApi.getTasks().size());
    }
}
