package com.example.emptyactivity1;

public class Question {
    private int  mTextResId;
    private boolean mAnswerTrue;
    public Question(int TextResId,boolean AnswerTrue){
        mAnswerTrue=AnswerTrue;
        mTextResId=TextResId;

    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
