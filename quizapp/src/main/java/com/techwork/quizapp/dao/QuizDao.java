package com.techwork.quizapp.dao;

import com.techwork.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author harsh_patel
 * Quiz Dao interface to fetch data from database
 */
@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
