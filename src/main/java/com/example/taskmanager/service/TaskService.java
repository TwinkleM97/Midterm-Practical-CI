package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        // FIX: Return a copy to avoid exposing internal list
        return new ArrayList<>(tasks);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void toggleTask(Long id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setCompleted(!task.isCompleted());
            }
        }
    }
}
