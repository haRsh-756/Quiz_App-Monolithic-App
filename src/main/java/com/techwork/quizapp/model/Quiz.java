package com.techwork.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * Represents a quiz within the quiz application.
 */
@Entity
@Data
public class Quiz {
    /**
     * The ID of the quiz.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The title of the quiz.
     */
    private String title;

    /**
     * The list of questions included in the quiz.
     */
    @ManyToMany
    private List<Question> question;
}
