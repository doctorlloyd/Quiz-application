package com.example.admin.quizapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class Results_Board extends Activity{
    private String possible_answers, questions_and_YourAnswers,questions_and_PossibleAnswers;
    private double score;
    private TextView tvDisplay,tvQuestions_and_YourAnswers,tvQuestions_and_PossibleAnswers;
    private ArrayList<String> answers = new ArrayList<String>();
    MediaPlayer song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results__board);
        final ToggleButton tbViewQuestions = (ToggleButton)findViewById(R.id.tbResults_board);
        initialize();
        song.start();
        possible_answers = getIntent().getStringExtra("string");
        score = getIntent().getDoubleExtra("score",0.00);
        answers = getIntent().getStringArrayListExtra("answers");
        setResultsBoard();
        tbViewQuestions.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                if(tbViewQuestions.isChecked())
                {
                    tvQuestions_and_YourAnswers.setVisibility(View.GONE);
                    tvQuestions_and_PossibleAnswers.setVisibility(View.VISIBLE);
                }else {
                    tvQuestions_and_PossibleAnswers.setVisibility(View.GONE);
                    tvQuestions_and_YourAnswers.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void initialize()
    {
        tvDisplay = (TextView)findViewById(R.id.tvResults_board);
        tvQuestions_and_YourAnswers = (TextView)findViewById(R.id.tvQuestions_and_YourAnswers);
        tvQuestions_and_PossibleAnswers = (TextView)findViewById(R.id.tvQuestions_and_PossibleAnswers);

        possible_answers="";
        questions_and_YourAnswers="";
        questions_and_PossibleAnswers="";
        song = MediaPlayer.create(Results_Board.this,R.raw.like);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getBaseContext(),Topics.class);
        startActivity(intent);
        finish();
    }
    public void setResultsBoard()
    {

        tvDisplay.setText("Your score is: "+score+"%");
        String[] separate_questions_and_answers = possible_answers.split("@");
        for(int i=0; i<separate_questions_and_answers.length;i++)
        {
            String[] finalString = separate_questions_and_answers[i].split(";");
            questions_and_YourAnswers += String.valueOf(i+1)+". "+finalString[0] +"     : Your answer: " + answers.get(i)+"\n\n";
            questions_and_PossibleAnswers += String.valueOf(i+1)+". "+finalString[0] +"     " + finalString[1]+"\n\n";
        }
        tvQuestions_and_YourAnswers.setText(questions_and_YourAnswers);
        tvQuestions_and_PossibleAnswers.setText(questions_and_PossibleAnswers);
    }

    @Override
    protected void onPause() {
        super.onPause();
        song.release();
    }
}
