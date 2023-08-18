package com.techwork.quizapp.controller;

import com.techwork.quizapp.model.Question;
import com.techwork.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author harsh_patel
 * Controller class that handles HTTP requests related to questions in the quiz application.
 * Controller layer of the system
 */
@RestController
@RequestMapping("question")
public class QuestionController {
    /**
     * QuestionService object instance to communicate with service layer
     */
    @Autowired
    private QuestionService questionService;

    /**
     * Retrieves all questions from the database.
     * @return A ResponseEntity containing a list of questions.
     */
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    /**
     * Retrieves questions by a specified category.
     *
     * @param category The category for which questions are to be retrieved.
     * @return A ResponseEntity containing a list of questions matching the specified category.
     */
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionByCategory(category);
    }

    /**
     * Adds a new question to the database.
     * @param question The question to be added.
     * @return A ResponseEntity indicating the success or failure of the addition.
     */
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    /**
     * Deletes a question from the database.
     * @param question The question to be deleted.
     * @return A ResponseEntity indicating the success or failure of the deletion.
     */
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteQuestion(@RequestBody Question question) {
        return questionService.deleteQuestion(question);
    }

    /**
     * Deletes a question based on its ID.
     * @param id The ID of the question to be deleted.
     * @return A ResponseEntity indicating the success or failure of the deletion.
     */
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {
        return questionService.deleteQuestion(id);
    }
}
