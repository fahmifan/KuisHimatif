package com.rz.kuishimatif.repository;

import com.rz.kuishimatif.R;
import com.rz.kuishimatif.model.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizRepoImpl implements QuizRepo {
    private List<Question> questions;

    public QuizRepoImpl() {
        questions = Arrays.asList(
            new Question(R.string.q_ketua_himatif, true),
            new Question(R.string.q_ketua_devcom, false),
            new Question(R.string.q_kaprodi, false)
        );
    }

    @Override
    public List<Question> questions() {
        return questions;
    }

    @Override
    public Question questions(int number) {
        return questions.get(number);
    }
}
