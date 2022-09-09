package fr.asys.starter.cleher.core.test.taskmanager.steps;

import java.util.ArrayList;
import java.util.List;

import fr.asys.starter.cleher.core.client.controllers.TaskCreationApi;
import fr.asys.starter.cleher.core.client.controllers.TaskDeletionApi;
import fr.asys.starter.cleher.core.client.controllers.TaskGetApi;
import fr.asys.starter.cleher.core.client.invoker.ApiException;
import fr.asys.starter.cleher.core.client.model.TaskDto;
import fr.asys.starter.cleher.core.test.taskmanager.steps.common.TaskManagerTestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TaskCreateStepDefinition {

    private final TaskManagerTestContext taskManagerTestContext;

    public TaskCreateStepDefinition(TaskManagerTestContext taskManagerTestContext) {
        this.taskManagerTestContext = taskManagerTestContext;
    }

    @Given("les tache suivante n'est pas présente dans le système")
    public void les_taches_suivantes_n_existent_pas_dans_le_systeme(DataTable data) throws ApiException {
        final List<TaskDto> tasks = new ArrayList<>();
        tasks.add(new TaskDto());
        tasks.get(0).id(Integer.parseInt(data.cell(1, 0)));
        tasks.get(0).task(data.cell(1, 1));
        tasks.get(0).done(Boolean.parseBoolean(data.cell(1, 2)));

        final TaskDeletionApi taskDeletionApi = taskManagerTestContext.getTaskDeletionApi();
        for (TaskDto task : tasks) {
            taskDeletionApi.deleteTask(task.getId());
        }
    }

    @When("je fais appel au endpoint des tâches pour créer les tâches suivantes")
    public void je_fais_appel_au_endpoint_pour_creer_des_taches(DataTable data) throws ApiException {
        final List<TaskDto> tasks = new ArrayList<>();
        tasks.add(new TaskDto());
        tasks.get(0).task(data.cell(1, 0));
        tasks.get(0).done(Boolean.parseBoolean(data.cell(1, 1)));

        final TaskCreationApi taskCreationApi = taskManagerTestContext.getTaskCreationApi();
        taskCreationApi.createTask1(tasks);
    }

    @Then("les taches suivantes sont présentes dans le système")
    public void les_taches_suivantes_sont_présentes_dans_le_système(DataTable data) throws ApiException {
        final List<TaskDto> tasks = new ArrayList<>();
        tasks.add(new TaskDto());
        tasks.get(0).task(data.cell(1, 0));
        tasks.get(0).done(Boolean.parseBoolean(data.cell(1, 1)));

        final TaskGetApi taskGetApi = taskManagerTestContext.getTaskGetApi();
        taskGetApi.getTasks();
    }
}
