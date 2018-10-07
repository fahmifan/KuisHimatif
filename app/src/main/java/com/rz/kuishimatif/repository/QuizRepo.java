package com.rz.kuishimatif.repository;

import com.rz.kuishimatif.model.Question;

import java.util.List;

/**
 * QuizRepo provide question quizes
 */
public interface QuizRepo {
    public List<Question> questions();
    public Question questions(int number);
}
