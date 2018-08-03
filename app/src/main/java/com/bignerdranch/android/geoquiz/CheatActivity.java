package com.bignerdranch.android.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.android.geoquiz" +
            ".answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "com.bignerdranch.android.geoquiz" +
            ".answer_shown";

    private static final String KEY_IS_ANSWER_SHOWN = "isAnswerShown";

    private boolean mAnswerIsTrue;
    private boolean mIsAnswerShown = false;

    private Button mShowButton;
    private TextView mAnswerTextView;

    // Create a new intent that is needed by CheatActivity
    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    // Decoder for QuizActivity to use the extra
    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

    // Add isAnswerShown to the saved data when activity is destroyed
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean(KEY_IS_ANSWER_SHOWN, mIsAnswerShown);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        // Restore data from the destroyed activity
        if(savedInstanceState != null) {
            mIsAnswerShown = savedInstanceState.getBoolean(KEY_IS_ANSWER_SHOWN);
            if(mIsAnswerShown) {
                setAnswerShownResult(true);
            }
        }

        // Retrive the data from the extra
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        // Wire up the answer text view
        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);

        // Wire up the show button
        mShowButton = (Button) findViewById(R.id.show_answer_button);
        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                mIsAnswerShown = true;
                setAnswerShownResult(true);
            }
        });
    }
}
