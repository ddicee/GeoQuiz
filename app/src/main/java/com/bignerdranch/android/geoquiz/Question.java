package com.bignerdranch.android.geoquiz;

/**
 * Created by Dice on 8/2/2018.
 */

public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;
    private boolean mIsCheated;

    public Question(int textResId, boolean answerTrue, boolean isCheated) {
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
        mIsCheated = isCheated;
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

    public boolean isCheated() {
        return mIsCheated;
    }

    public void setCheated(boolean cheated) {
        mIsCheated = cheated;
    }
}
