package com.techwork.quizapp.service;

import com.techwork.quizapp.dao.QuestionDao;
import com.techwork.quizapp.dao.QuizDao;
import com.techwork.quizapp.model.Question;
import com.techwork.quizapp.model.QuestionWrapper;
import com.techwork.quizapp.model.Quiz;
import com.techwork.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author harsh_patel
 * Service class that provides methods for managing quizzes and their associated questions.
 * class of service layer
 */
@Service
public class QuizService {
    /**
     * Quiz Data Access Object instance for fetching data from database
     */
    @Autowired
    private QuizDao quizDao;
    /**
     * Question Data Access Object instance for fetching data from database
     */
    @Autowired
    private QuestionDao questionDao;

    /**
     * Creates a new quiz with a specified number of questions from a given category.
     * @param category The category for selecting questions.
     * @param numQ     The number of questions to include in the quiz.
     * @param title    The title of the quiz.
     * @return A ResponseEntity indicating the success or failure of quiz creation.
     */
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
    /**
     * Retrieves the questions of a quiz in a simplified format for users.
     * @param id The ID of the quiz.
     * @return A ResponseEntity containing a list of QuestionWrapper objects representing quiz questions.
     */
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestion();
        List<QuestionWrapper> questionsForUsers = new ArrayList<>();
        for (Question q : questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(),
                    q.getOption1(), q.getOption2(),
                    q.getOption3(), q.getOption4());
            questionsForUsers.add(qw);
        }

        return new ResponseEntity<>(questionsForUsers, HttpStatus.OK);
    }
    /**
     * Calculates the result of a quiz based on user responses.
     * @param id        The ID of the quiz.
     * @param responses A list of user responses.
     * @return A ResponseEntity containing the number of correct responses.
     */
    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questions = quiz.get().getQuestion();
        int correct = 0;
        int i = 0;
        for (Response response : responses) {
            if (response.getResponse().equals(questions.get(i).getRightAnswer())) {
                correct++;
            }
            i++;
        }
        return new ResponseEntity<>(correct, HttpStatus.OK);
    }
}
