package dev_diary_app_backend.services;

import java.util.List;
import java.util.Optional;

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

    public List<Task> getAllTasks(String userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task updateTask(Task taskData) {
         Optional<Task> existingTaskOptional = taskRepository.findById(taskData.getId());

         if (existingTaskOptional.isPresent()) {
             Task existingTask = existingTaskOptional.get();
             existingTask.setDescription(taskData.getDescription());
             existingTask.setStatus(taskData.getStatus());

             return taskRepository.save(existingTask);
         } else {
             throw new RuntimeException("Task not found with id: " + taskData.getId());
         }
    }

    public Task updateCompleteStatus(String id) {
        Optional<Task> existingTaskOptional = taskRepository.findById(id);
        
        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            existingTask.setComplete(!existingTask.isComplete());

            return taskRepository.save(existingTask);
        } else {
            throw new RuntimeException("Task not found with id: " + id);
        }
    }

    public boolean deleteTask(String id) throws Exception{
        try {
            Optional<Task> existingTaskOptional = taskRepository.findById(id);
            // Verificar se essa é a forma correta de tratar exeção e se esse é melhor maneira de deletar.
            if(existingTaskOptional.isPresent()) {
                Task existingTask = existingTaskOptional.get();
                taskRepository.delete(existingTask);
                return true;
            } else {
                return false;
            }
               
        } catch (Exception e) {
            throw new Exception("Task was not deleted.");
        }
    }
}
