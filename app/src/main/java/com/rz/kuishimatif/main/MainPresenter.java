package com.rz.kuishimatif.main;

import com.rz.kuishimatif.model.Question;
import com.rz.kuishimatif.repository.QuizRepo;

public class MainPresenter implements MainContract.Presenter {

    private int questNum = 0;

    // We control the view
    MainContract.View view;

    // We need the Questions
    QuizRepo quizRepo;

    public MainPresenter(MainContract.View view, QuizRepo quizRepo) {
        this.view = view;
        this.quizRepo = quizRepo;
    }

    private void raiseQuestNum() {
        questNum = (questNum + 1) % quizRepo.questions().size();
    }

    @Override
    public void showQuestion() {
        raiseQuestNum();

        Question current = quizRepo.questions(questNum);
        view.showQuestion(current);
    }

    @Override
    public void checkAnswer(boolean answerBtn) {
        boolean answer = quizRepo.questions().get(questNum).getAnswer();
        view.showAnswerResponse(answer == answerBtn);
    }

}
