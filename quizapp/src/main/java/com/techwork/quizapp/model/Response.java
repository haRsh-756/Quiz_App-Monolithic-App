package com.techwork.quizapp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author harsh_patel
 * Response entity to hold id and user's response of a question
 */
@Data
@RequiredArgsConstructor
public class Response {
    /**
     * id of the question
     */
    private Integer id;
    /**
     * response of that question id
     */
    private String response;
}
