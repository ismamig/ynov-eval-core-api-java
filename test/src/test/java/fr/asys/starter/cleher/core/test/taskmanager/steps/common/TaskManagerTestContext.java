package fr.asys.starter.cleher.core.test.taskmanager.steps.common;

import fr.asys.starter.cleher.core.client.controllers.*;
import fr.asys.starter.cleher.core.client.invoker.ApiClient;

public class TaskManagerTestContext {
    private TaskCreationApi taskCreationApi;
    private TaskDeletionApi taskDeletionApi;
    private TaskUpdateApi taskUpdateApi;
    private TaskGetApi taskGetApi;
    private ApiClient taskManagerApiClient;

    public ApiClient getTaskManagerApiClient() {
        return taskManagerApiClient;
    }

    public void setTaskManagerApiClient(ApiClient taskManagerApiClient) {
        this.taskManagerApiClient = taskManagerApiClient;
    }

    public TaskManagerTestContext(ApiClient apiClient) {
        setTaskManagerApiClient(apiClient);
        buildTaskApi();
    }

    public void buildTaskApi() {
        taskCreationApi = new TaskCreationApi(this.getTaskManagerApiClient());
        taskDeletionApi = new TaskDeletionApi(this.getTaskManagerApiClient());
        taskGetApi = new TaskGetApi(this.getTaskManagerApiClient());
        taskUpdateApi = new TaskUpdateApi(this.getTaskManagerApiClient());
    }

    public TaskGetApi getTaskGetApi() {
        return taskGetApi;
    }

    public TaskCreationApi getTaskCreationApi() {
        return taskCreationApi;
    }

    public TaskDeletionApi getTaskDeletionApi() {
        return taskDeletionApi;
    }

    public TaskUpdateApi getTaskUpdateApi() {
        return taskUpdateApi;
    }
}
