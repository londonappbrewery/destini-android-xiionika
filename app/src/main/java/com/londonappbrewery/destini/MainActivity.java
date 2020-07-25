package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mStoryTextView;
    private Button mTopButton;
    private Button mBottomButton;
    private int mState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStoryTextView = findViewById(R.id.storyTextView);
        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);

        showButtons();
        mState = 0;

        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mState == 0) || (mState == 1)) {
                    mStoryTextView.setText(R.string.T3_Story);
                    mTopButton.setText(R.string.T3_Ans1);
                    mBottomButton.setText(R.string.T3_Ans2);
                    mState = 2;
                } else {
                    mStoryTextView.setText(R.string.T6_End);
                    hideButtons();
                }
            }
        });

        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (mState) {
                    case 0:
                        mStoryTextView.setText(R.string.T2_Story);
                        mTopButton.setText(R.string.T2_Ans1);
                        mBottomButton.setText(R.string.T2_Ans2);
                        mState = 1;
                        break;
                    case 1:
                        mStoryTextView.setText(R.string.T4_End);
                        hideButtons();
                        break;
                    case 2:
                        mStoryTextView.setText(R.string.T5_End);
                        hideButtons();
                }
            }
        });

    }

    private void hideButtons() {
        mTopButton.setVisibility(View.INVISIBLE);
        mTopButton.setClickable(false);
        mBottomButton.setVisibility(View.INVISIBLE);
        mBottomButton.setClickable(false);
    }

    private void showButtons() {
        mTopButton.setVisibility(View.VISIBLE);
        mTopButton.setClickable(true);
        mBottomButton.setVisibility(View.VISIBLE);
        mBottomButton.setClickable(true);
    }
}
