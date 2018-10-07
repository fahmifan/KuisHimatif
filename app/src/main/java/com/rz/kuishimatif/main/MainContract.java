package com.rz.kuishimatif.main;

import com.rz.kuishimatif.model.Question;

public interface MainContract {
    interface View {
        void showQuestion(Question question);
        void showAnswerResponse(boolean correct);
    }

    interface Presenter {
        void showQuestion();
        void checkAnswer(boolean answerBtn);
    }
}
