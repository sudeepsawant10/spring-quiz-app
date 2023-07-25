package com.example.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Data
@Entity
public class Quiz{
    // Multiple quiz with multiple questions (repeated)
    //Two different quiz can have same questions that's why ManyToMany Relationship

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String quizTitle;

    @ManyToMany
    private List<Question> questions;
}
