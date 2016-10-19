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
public class Cars extends Activity implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup rg1,rg2,rg3,rg4,rg5,rg6,rg7,rg8,rg9;
    private TextView tvTopic;
    private int counter;
    private ArrayList<String> answers = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cars);
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
        rg8 = (RadioGroup)findViewById(R.id.rg8);
        rg9 = (RadioGroup)findViewById(R.id.rg9);

        tvTopic = (TextView)findViewById(R.id.tvTopic);

        rg1.setOnCheckedChangeListener(this);
        rg2.setOnCheckedChangeListener(this);
        rg3.setOnCheckedChangeListener(this);
        rg4.setOnCheckedChangeListener(this);
        rg5.setOnCheckedChangeListener(this);
        rg6.setOnCheckedChangeListener(this);
        rg7.setOnCheckedChangeListener(this);
        rg8.setOnCheckedChangeListener(this);
        rg9.setOnCheckedChangeListener(this);
    }
    public String cars() {
        String str = "Q: What country are Volvo's from?;Correct Answer: Sweden"
                + "@Q: What car company owns the Malibu?;Correct Answer: Chevrolet"
                + "@Q: When was the car company Nissan founded?;Correct Answer: 1932"
                + "@Q: What car company recently bought out Mercedes?;Correct Answer: Daimler Chrysler"
                + "@Q: What is the cheapest NEW car in the world?;Correct Answer: Tata Nano"
                + "@Q: Rounded to the nearest digit, what is the fastest land speed ever recorded?;Correct Answer: 760 mph"
                + "@Q: What was the cars name from the previous question?;Correct Answer: ThrustSSC"
                + "@Q: When was the Toyota Prius made?;Correct Answer: 2000"
                + "@Q: Last Question, what is the horsepower of a new 2012 Camry V6?;Correct Answer:268";
        return str;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(group.getId()==R.id.rg1){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq13)
                counter ++;
        }

        if(group.getId()==R.id.rg2){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq21)
                counter ++;
        }

        if(group.getId()==R.id.rg3){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq34)
                counter ++;
        }

        if(group.getId()==R.id.rg4){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq41)
                counter ++;
        }

        if(group.getId()==R.id.rg5){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq51)
                counter ++;
        }

        if(group.getId()==R.id.rg6){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq64)
                counter ++;
        }

        if(group.getId()==R.id.rg7){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq73)
                counter ++;
        }
        if(group.getId()==R.id.rg8){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq81)
                counter ++;
        }
        if(group.getId()==R.id.rg9){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq94)
                counter ++;
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

        if(answers.size()>=9) {
            Intent intent = new Intent(getBaseContext(),Results_Board.class);
            intent.putExtra("score",calculatePercentage());
            intent.putExtra("string",cars());
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
        double percentage = (counter/9) * 100;
        return  percentage;
    }
}
