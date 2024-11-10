package dev_diary_app_backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev_diary_app_backend.exceptions.BadRequestException;
import dev_diary_app_backend.exceptions.NotFoundException;
import dev_diary_app_backend.models.Task;
import dev_diary_app_backend.repository.TaskRepository;

@Service
public class TaskListService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createNewTask(Task taskData) {
        return taskRepository.save(taskData);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Task taskData) {
        Optional<Task> existingTaskOptional = taskRepository.findById(taskData.getId());

        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            existingTask.setDescription(taskData.getDescription());
            existingTask.setStatus(taskData.getStatus());

            return taskRepository.save(existingTask);
        } else {
            throw new NotFoundException("Task not found");
        }
    }

    public Task updateCompleteStatus(String id) {
        Optional<Task> existingTaskOptional = taskRepository.findById(id);

        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            existingTask.setComplete(!existingTask.isComplete());

            return taskRepository.save(existingTask);
        } else {
            throw new NotFoundException("Task not found");
        }
    }

    public boolean deleteTask(String id) throws Exception {
        Optional<Task> existingTaskOptional = taskRepository.findById(id);
        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            taskRepository.delete(existingTask);
            
            return true;
        } else {
            throw new BadRequestException("Task was not deleted.");
        }
    }
}
