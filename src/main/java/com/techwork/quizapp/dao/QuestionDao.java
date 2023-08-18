package com.techwork.quizapp.dao;

import com.techwork.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author harsh_patel
 * Repository interface for managing Question entities in the database.
 * interface of DAO layer
 */
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    /**
     * Retrieves a list of questions based on the specified category.
     *
     * @param category The category for which questions are to be retrieved.
     * @return A list of questions matching the specified category.
     */
    List<Question> findByCategory(String category);

    /**
     * Retrieves a specified number of randomly selected questions from the given category.
     * @param category The category for selecting questions.
     * @param numQ     The number of questions to retrieve.
     * @return A list of randomly selected questions from the specified category.
     */
    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int numQ);
}
