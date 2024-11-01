package dev_diary_app_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev_diary_app_backend.models.Task;
import dev_diary_app_backend.repository.TaskRepository;

@Service
public class TaskListService {

    @Autowired
    private TaskRepository taskRepository;
    
    public Task createNewTask(Task taskData) {
        return taskRepository.save(taskData);
    }
}
