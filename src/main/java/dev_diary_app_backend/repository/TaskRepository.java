package dev_diary_app_backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev_diary_app_backend.models.Task;


public interface TaskRepository extends MongoRepository<Task, String>{
    List<Task> findByDescription(String description);
}
