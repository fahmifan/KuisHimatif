package com.rz.kuishimatif.model;

public class Question {
    private int mTextResId;
    private boolean mAnswer;

    public Question(int textResId, boolean answer){
        mTextResId = textResId;
        mAnswer = answer;
    }

    //getter
    public int getTextResId() {
        return mTextResId;
    }
    public boolean getAnswer() {
        return mAnswer;
    }
    //setter
    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }
    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }


}
