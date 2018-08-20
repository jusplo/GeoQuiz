package com.example.justyna.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;




public class QuizActivity extends AppCompatActivity {
    private static final String TAG = "QuizActivity";
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPreviousButton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };

    private int mCurrentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Wywołanie metody: onCreate(Bundle)");
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        /*mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });*/

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast myToast = Toast.makeText(QuizActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_SHORT);
                myToast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0 ,0 );
                myToast.show();
            }
        });
        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast myToast = Toast.makeText(QuizActivity.this,
                        R.string.incorrect_toast,
                        Toast.LENGTH_SHORT);
                myToast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                myToast.show();
            }
        });
        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        updateQuestion();


        mPreviousButton = (Button) findViewById(R.id.previous_button);
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 mCurrentIndex = (mCurrentIndex -1) % mQuestionBank.length;
                 updateQuestion();
                 }
        });
        updateQuestion();
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Wywołanie metody: onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Wywołanie metody: onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Wywołanie metody: onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Wywołanie metody: onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Wywołanie metody: onDestroy()");
    }

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswear(boolean userPressedTrue) {
        boolean answearIsTrue = mQuestionBank[mCurrentIndex].isAnswearTrue();
        int messageResId = 0;
        if (userPressedTrue == answearIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
}


