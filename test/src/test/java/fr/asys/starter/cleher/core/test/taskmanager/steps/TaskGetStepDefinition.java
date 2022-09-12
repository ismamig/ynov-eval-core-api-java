package fr.asys.starter.cleher.core.test.taskmanager.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;

import fr.asys.starter.cleher.core.client.controllers.TaskCreationApi;
import fr.asys.starter.cleher.core.client.controllers.TaskGetApi;
import fr.asys.starter.cleher.core.client.invoker.ApiException;
import fr.asys.starter.cleher.core.client.model.TaskDto;
import fr.asys.starter.cleher.core.test.taskmanager.steps.common.TaskManagerTestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TaskGetStepDefinition {
    private final TaskManagerTestContext taskManagerTestContext;

    public TaskGetStepDefinition(TaskManagerTestContext taskManagerTestContext) {
        this.taskManagerTestContext = taskManagerTestContext;
    }

    @Given("les taches suivantes existent")
    public void les_taches_suivantes_existent(final List<TaskDto> tasks) throws ApiException {
        final TaskCreationApi taskCreationApi = taskManagerTestContext.getTaskCreationApi();
        taskCreationApi.createTask(tasks);
    }

    @When("je fais appel au endpoint des tâches pour récupérer les tâches")
    public void je_fais_appel_au_endpoint_pour_recuperer_les_taches() throws ApiException {
        final TaskGetApi taskGetApi = taskManagerTestContext.getTaskGetApi();
        taskGetApi.getTasks();
    }

    @Then("j'ai au moins une tache")
    public void jai_au_moins_une_tache() throws ApiException {
        final TaskGetApi taskGetApi = taskManagerTestContext.getTaskGetApi();
        assertTrue(taskGetApi.getTasks().size() > 0);
    }
}
