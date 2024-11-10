package dev_diary_app_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev_diary_app_backend.models.Task;
import dev_diary_app_backend.services.TaskListService;

@RestController //Indentifica que essa classe é um controlador que gerencia requisições HTTP.
@RequestMapping("/tasks-list") // indentifica o endpoint em que a classe escuta.
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskListService TaskListService;

    @GetMapping // -> identifica o método GET 
    public ResponseEntity<List<Task>> getTask() {
        List<Task> listTask = TaskListService.getAllTasks();
        return new ResponseEntity<>(listTask, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> postTask(@RequestBody Task body) {
        Task taskCreated = TaskListService.createNewTask(body);
        return new ResponseEntity<>(taskCreated, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody Task body) {
        Task taskCreated = TaskListService.createNewTask(body);
        return new ResponseEntity<>(taskCreated, HttpStatus.OK);
    }

    @PutMapping("status/{id}")
    public ResponseEntity<Task> putMethodName(@PathVariable String id) {
        Task taskCreated = TaskListService.updateCompleteStatus(id);
        return new ResponseEntity<>(taskCreated, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable String id) throws Exception {
        TaskListService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
