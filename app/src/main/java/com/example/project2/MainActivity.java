package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int firstPlayerScore = 0;
    public static int secondPlayerScore = 0;
    public static int firstPlayerRoundScore = 1;
    public static int secondPlayerRoundScore = 1;
    public static int roundNumber = 1;
    TextView roundTextView;
    TextView firstPlayerRoundScoreView;
    TextView secondPlayerRoundScoreView;
    TextView firstPlayerScoreView;
    TextView secondPlayerScoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roundTextView = (TextView) findViewById(R.id.roundNumber);
        firstPlayerRoundScoreView = (TextView) findViewById(R.id.firstPlayerRoundScore);
        secondPlayerRoundScoreView = (TextView) findViewById(R.id.secondPlayerRoundScore);
        firstPlayerScoreView = (TextView) findViewById(R.id.firstPlayerScore);
        secondPlayerScoreView = (TextView) findViewById(R.id.secondPlayerScore);
        Button leftButton = (Button) findViewById(R.id.leftButton);
        Button rightButton = (Button) findViewById(R.id.rightButton);
        Button resetButton = (Button) findViewById(R.id.resetButton);

        leftButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (firstPlayerScore == 10) {
                    roundNumber++;
                    roundTextView.setText("ROUND " + String.valueOf(roundNumber));
                    firstPlayerRoundScoreView.setText(String.valueOf(firstPlayerRoundScore));
                    firstPlayerRoundScore++;
                    resetScore();
                }
                else {
                    firstPlayerScore++;
                    firstPlayerScoreView.setText(String.valueOf(firstPlayerScore));
                }
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (secondPlayerScore == 10) {
                    roundNumber++;
                    roundTextView.setText("ROUND " + String.valueOf(roundNumber));
                    secondPlayerRoundScoreView.setText(String.valueOf(secondPlayerRoundScore));
                    secondPlayerRoundScore++;
                    resetScore();
                }
                else {
                    secondPlayerScore++;
                    secondPlayerScoreView.setText(String.valueOf(secondPlayerScore));
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                resetAll();
            }
        });

    }

    public void resetAll() {
        firstPlayerScore = secondPlayerScore = 0;
        firstPlayerRoundScore = secondPlayerRoundScore = 1;
        roundNumber = 1;
        roundTextView.setText("ROUND 1");
        firstPlayerRoundScoreView.setText("0");
        secondPlayerRoundScoreView.setText("0");
        firstPlayerScoreView.setText("0");
        secondPlayerScoreView.setText("0");
    }

    public void resetScore() {
        firstPlayerScore = secondPlayerScore = 0;
        firstPlayerScoreView.setText("0");
        secondPlayerScoreView.setText("0");
    }
}