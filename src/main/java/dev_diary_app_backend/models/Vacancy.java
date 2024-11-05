package dev_diary_app_backend.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Document(collection = "vacancys")

public class Vacancy {
    private String name;
    private String url;
    private String company;
    private String status;
}
