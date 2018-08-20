package com.example.justyna.geoquiz;

public class Question {

    private int mTextResId;
    private boolean mAnswearTrue;

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswearTrue() {
        return mAnswearTrue;
    }

    public void setAnswearTrue(boolean answearTrue) {
        mAnswearTrue = answearTrue;
    }



    public Question(int textResId, boolean answearTrue) {
        mTextResId = textResId;
        mAnswearTrue = answearTrue;
    }
}
