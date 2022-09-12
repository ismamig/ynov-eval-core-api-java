package fr.asys.starter.cleher.core.test.taskmanager.steps;

import static org.junit.Assert.assertEquals;

import java.util.List;

import fr.asys.starter.cleher.core.client.controllers.TaskCreationApi;
import fr.asys.starter.cleher.core.client.controllers.TaskGetApi;
import fr.asys.starter.cleher.core.client.controllers.TaskUpdateApi;
import fr.asys.starter.cleher.core.client.invoker.ApiException;
import fr.asys.starter.cleher.core.client.model.TaskDto;
import fr.asys.starter.cleher.core.test.taskmanager.steps.common.TaskManagerTestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TaskUpdateStepDefinition {
    private final TaskManagerTestContext taskManagerTestContext;

    public TaskUpdateStepDefinition(TaskManagerTestContext taskManagerTestContext) {
        this.taskManagerTestContext = taskManagerTestContext;
    }

    @Given("les taches suivantes existent dans le systeme")
    public void les_taches_suivantes_sont_presentes(final List<TaskDto> tasks) throws ApiException {
        final TaskCreationApi taskCreationApi = taskManagerTestContext.getTaskCreationApi();
        taskCreationApi.createTask(tasks);
    }

    @When("je passe mes taches à done")
    public void je_passe_mes_taches_a_done() throws ApiException {
        final TaskUpdateApi taskUpdateApi = taskManagerTestContext.getTaskUpdateApi();
        final TaskGetApi taskGetApi = taskManagerTestContext.getTaskGetApi();

        for (final TaskDto task : taskGetApi.getTasks()) {
            task.done(true);
            taskUpdateApi.updateTask(task.getId(), task);
        }
    }

    @Then("toutes mes taches sont done")
    public void toutes_mes_taches_sont_done() throws ApiException {
        final TaskGetApi taskGetApi = taskManagerTestContext.getTaskGetApi();

        for (TaskDto task : taskGetApi.getTasks()) {
            assertEquals(Boolean.TRUE, task.getDone());
        }
    }
}
