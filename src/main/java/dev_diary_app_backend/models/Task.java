package dev_diary_app_backend.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Document(collection = "tasks")
public class Task {
    private String userId;
    private String description;
    private String status;
    private boolean complete;
}
