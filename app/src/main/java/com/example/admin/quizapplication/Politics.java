package com.example.admin.quizapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Admin on 2016/10/17.
 */
public class Politics extends Activity implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup rg1,rg2,rg3,rg4,rg5,rg6,rg7;
    private TextView tvTopic;
    private int counter;
    private ArrayList<String> answers = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.politics);
        initialize();
        String topic = getIntent().getStringExtra("topic");
        tvTopic.setText(topic);
    }
    public void initialize()
    {
        rg1 = (RadioGroup) findViewById(R.id.rg1);
        rg2 = (RadioGroup)findViewById(R.id.rg2);
        rg3 = (RadioGroup)findViewById(R.id.rg3);
        rg4 = (RadioGroup)findViewById(R.id.rg4);
        rg5 = (RadioGroup)findViewById(R.id.rg5);
        rg6 = (RadioGroup)findViewById(R.id.rg6);
        rg7 = (RadioGroup)findViewById(R.id.rg7);

        tvTopic = (TextView)findViewById(R.id.tvTopic);

        rg1.setOnCheckedChangeListener(this);
        rg2.setOnCheckedChangeListener(this);
        rg3.setOnCheckedChangeListener(this);
        rg4.setOnCheckedChangeListener(this);
        rg5.setOnCheckedChangeListener(this);
        rg6.setOnCheckedChangeListener(this);
        rg7.setOnCheckedChangeListener(this);
    }
    public String politics() {
        String str = "Q: Who is the first black president of South Africa?;Correct Answer: Nelson Mandela"
                + "@Q: Which year did black people start voting here in South Africa?;Correct Answer: 1994"
                + "@Q: Which year Mandela died?;Correct Answer: 2012"
                + "@Q: Which political party do Julius belongs to?;Correct Answer: EFF"
                + "@Q: Who is the President of the country?;Correct Answer: Jacob Zuma"
                + "@Q: Which year was Nelson Mandela born?;Correct Answer: 1918"
                + "@Q: Who was the first women Mandela got married to?;Correct Answer: Winnie Mandela";
        return str;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if(group.getId()==R.id.rg1){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq14)
            {
                counter ++;
            }
        }

        if(group.getId()==R.id.rg2){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq21)
            {
                counter ++;
            }
        }

        if(group.getId()==R.id.rg3){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq33)
            {
                counter ++;
            }
        }

        if(group.getId()==R.id.rg4){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq43)
            {
                counter ++;
            }
        }

        if(group.getId()==R.id.rg5){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq53)
            {
                counter ++;
            }
        }

        if(group.getId()==R.id.rg6){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq64)
            {
                counter ++;
            }
        }

        if(group.getId()==R.id.rg7){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq73)
            {
                counter ++;
            }
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getBaseContext(),Topics.class);
        startActivity(intent);
        finish();
    }
    public void proceedToScore(View view)
    {
        if(answers.size()>=7) {
            Intent intent = new Intent(getBaseContext(), Results_Board.class);
            intent.putExtra("score", calculatePercentage());
            intent.putExtra("string", politics());
            intent.putStringArrayListExtra("answers", answers);
            startActivity(intent);
            finish();
        }else
        {
            Toast.makeText(getBaseContext(),"YOU DIDN'T ANSWER ALL THE QUESTIONS",Toast.LENGTH_LONG).show();
        }
    }

    public double calculatePercentage()
    {
        double percentage = (counter/7) * 100;
        return  percentage;
    }
}
