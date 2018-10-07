package com.rz.kuishimatif.main;

import com.rz.kuishimatif.model.Question;
import com.rz.kuishimatif.repository.QuizRepo;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    MainContract.View view;
    @Mock
    QuizRepo quizRepo;

    MainContract.Presenter presenter;

    List<Question> MANY_QUESTION = Arrays.asList(
            new Question(1, true),
            new Question(2, false),
            new Question(3, true)
    );

    @Before
    public void setUp() {
        presenter = new MainPresenter(view, quizRepo);
    }


    @Test
    public void should_show_question_when_available() {
        when(quizRepo.questions(3)).thenReturn(MANY_QUESTION.get(1));
        presenter.showQuestion();
        verify(view).showQuestion(MANY_QUESTION.get(0));
    }
}