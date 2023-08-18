package com.techwork.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author harsh_patel
 * Represents a question within the quiz application.
 */
@Data
@Entity
public class Question {
    /**
     * primary key id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * The category to which the question belongs.
     */
    private String category;
    /**
     * The difficulty level of the question.
     */
    @Column(name = "difficultylevel")
    private String difficultyLevel;
    /**
     * The first option for the question.
     */
    private String option1;
    /**
     * The second option for the question.
     */
    private String option2;
    /**
     * The third option for the question.
     */
    private String option3;
    /**
     * The fourth option for the question.
     */
    private String option4;
    /**
     * The title or content of the question.
     */
    @Column(name = "questiontitle")
    private String questionTitle;
    /**
     * The correct answer to the question.
     */
    @Column(name = "rightanswer")
    private String rightAnswer;
}
