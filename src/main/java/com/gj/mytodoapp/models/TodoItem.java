package com.gj.mytodoapp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.Date;
@Data
@Entity
@Table(name = "TodoItem")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
    private boolean isCompleted;

}
