package de.weltraumschaf.nas.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import de.weltraumschaf.nas.api.Task;
import de.weltraumschaf.nas.api.TaskService;

public final class TaskServiceImpl implements TaskService {

    private final Map<String, Task> tasks = new HashMap<>();

    public TaskServiceImpl() {
        super();
        Task task = new Task();
        task.setId("1");
        task.setTitle("Buy some coffee");
        task.setDescription("Take the extra strong");
        addTask(task);
        task = new Task();
        task.setId("2");
        task.setTitle("Finish karaf tutorial");
        task.setDescription("Last check and wiki upload");
        addTask(task);
    }

    @Override
    public Task getTask(final String id) {
        return tasks.get(id);
    }

    @Override
    public void addTask(final Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public Collection<Task> getTasks() {
        // taskMap.values is not serializable
        return new ArrayList<Task>(tasks.values());
    }

    @Override
    public void updateTask(final Task task) {
        tasks.put(task.getId(), task);
    }

    @Override
    public void deleteTask(final String id) {
        tasks.remove(id);
    }

}
