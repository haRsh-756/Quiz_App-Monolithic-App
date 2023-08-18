package com.techwork.quizapp.controller;

import com.techwork.quizapp.model.QuestionWrapper;
import com.techwork.quizapp.model.Response;
import com.techwork.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author harsh_patel
 * class of a Controller layer
 * Controller class that handles HTTP requests related to quizzes in the quiz application.
 */
@RestController
@RequestMapping("quiz")
public class QuizController {
    /**
     * Quiz service object instance to communicate with service layer
     */
    @Autowired
    private QuizService quizService;

    /**
     * Creates a new quiz based on the specified category, number of questions, and title.
     * @param category The category for selecting questions.
     * @param numQ     The number of questions in the quiz.
     * @param title    The title of the quiz.
     * @return A ResponseEntity indicating the success or failure of quiz creation.
     */
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        return quizService.createQuiz(category, numQ, title);
    }

    /**
     * Retrieves the questions of a quiz in a simplified format for users.
     * @param id The ID of the quiz.
     * @return A ResponseEntity containing a list of QuestionWrapper objects representing quiz questions.
     */
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
        return quizService.getQuizQuestions(id);
    }

    /**
     * Submits user responses for a quiz and calculates the result.
     * @param id        The ID of the quiz.
     * @param responses A list of user responses.
     * @return A ResponseEntity containing the number of correct responses.
     */
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
        return quizService.calculateResult(id, responses);
    }
}
