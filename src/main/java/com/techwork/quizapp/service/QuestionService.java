package com.techwork.quizapp.service;

import com.techwork.quizapp.model.Question;
import com.techwork.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author harsh_patel
 * class of a service layer
 * This service class provides methods to manage questions within the quiz application.
 * second layer of the monolithic system
 */
@Service
public class QuestionService {
    /**
     * Retrieves all questions from the database.
     * @return A ResponseEntity containing a list of questions, or an empty list if an error occurs.
     */
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    /**
     * Retrieves questions based on the specified category.
     * @param category The category for which questions are to be retrieved.
     * @return A ResponseEntity containing a list of questions of the specified category, or an empty list if an error occurs.
     */
    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    /**
     * Adds a new question to the database.
     * @param question The question to be added.
     * @return A ResponseEntity indicating the success or failure of the addition.
     */
    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("successfully added", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong",HttpStatus.BAD_REQUEST);
        }
    }
    /**
     * Deletes the specified question from the database.
     * @param question The question to be deleted.
     * @return A ResponseEntity indicating the success or failure of the deletion.
     */
    public ResponseEntity<String> deleteQuestion(Question question) {
        try {
            questionDao.delete(question);
            return new ResponseEntity<>("successfully deleted",HttpStatus.ACCEPTED);
        }catch (Exception e){
            return  new ResponseEntity<>("Something went wrong",HttpStatus.NOT_FOUND);
        }
    }
    /**
     * Deletes a question based on the specified question ID.
     * @param id The ID of the question to be deleted.
     * @return A ResponseEntity indicating the success or failure of the deletion.
     */
    public ResponseEntity<String> deleteQuestion(Integer id){
        try {
            questionDao.deleteById(id);
            return new ResponseEntity<>("successfully deleted " + id + "th question",HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Something went wrong",HttpStatus.NOT_FOUND);
        }
    }
}
