package fr.asys.starter.cleher.core.test.taskmanager.steps;

import java.util.ArrayList;
import java.util.List;

import fr.asys.starter.cleher.core.client.controllers.TaskCreationApi;
import fr.asys.starter.cleher.core.client.controllers.TaskGetApi;
import fr.asys.starter.cleher.core.client.invoker.ApiException;
import fr.asys.starter.cleher.core.client.model.TaskDto;
import fr.asys.starter.cleher.core.test.taskmanager.steps.common.TaskManagerTestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TaskGetStepDefinition {
    private final TaskManagerTestContext taskManagerTestContext;

    public TaskGetStepDefinition(TaskManagerTestContext taskManagerTestContext) {
        this.taskManagerTestContext = taskManagerTestContext;
    }

    @Given("les taches suivantes sont présentes dans le système")
    public void les_taches_suivantes_sont_presentes(DataTable data) throws ApiException {

        final List<TaskDto> tasks = new ArrayList<>();
        tasks.add(new TaskDto());
        tasks.get(0).id(Integer.parseInt(data.cell(1, 0)));
        tasks.get(0).task(data.cell(1, 1));
        tasks.get(0).done(Boolean.parseBoolean(data.cell(1, 2)));

        final TaskCreationApi taskCreationApi = taskManagerTestContext.getTaskCreationApi();
        taskCreationApi.createTask1(tasks);
    }

    @When("je fais appel au endpoint des tâches pour récupérer les tâches")
    public void je_fais_appel_au_endpoint_pour_recuperer_les_taches(DataTable data) throws ApiException {
        // TODO: ?
    }

    @Then("je recupère les taches suivantes")
    public void je_recupere_les_taches(DataTable data) throws ApiException {
        final TaskGetApi taskGetApi = taskManagerTestContext.getTaskGetApi();
        taskGetApi.getTasks();
    }
}
