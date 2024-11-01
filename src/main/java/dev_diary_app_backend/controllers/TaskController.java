package dev_diary_app_backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev_diary_app_backend.models.Task;
import dev_diary_app_backend.services.TaskListService;

@RestController //Indentifica que essa classe é um controlador que gerencia requisições HTTP.
@RequestMapping("/tasks-list") // indentifica o endpoint em que a classe escuta.

public class TaskController {

    @Autowired
    private TaskListService TaskListService;

    @GetMapping // -> identifica o método GET 
    public String getTask() {
        // return TaskListService.createNewTask();
        return "redando";
    }

    @PostMapping
    public ResponseEntity<Task> postTask(@RequestBody Task body) {
        Task taskCreated = TaskListService.createNewTask(body);
        return new ResponseEntity<>(taskCreated, HttpStatus.CREATED);
    }
}
