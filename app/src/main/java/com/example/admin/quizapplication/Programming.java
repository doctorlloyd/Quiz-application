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
public class Programming extends Activity implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup rg1,rg2,rg3,rg4,rg5,rg6,rg7;
    private TextView tvTopic;
    private int counter;
    private ArrayList<String> answers = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.programming);
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
    public String programming() {
        String str = "Q: Which package needs to be imported so that you can accept user input?;Answer: Option D"+
                "@Q: Which of the following GUI components can be included in a Java frame?;Answer: Option C" +
                "@Q: Which of the following can be used to access the first element of an array named arrOne?;Answer: Option A" +
                "@Q: What is the difference between a try-catch block and a try-catch-finally block?;Answer: Option B" +
                "@Q: What kind of data will this variable store - char fName?;Answer: Option A" +
                "@Q: Which keyword would you use if you wanted a class to use an interface?;Answer: Option B" +
                "@Q: Which Java exception should be used to handle input/output errors?;Answer: Option D";
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
            if(checkedId==R.id.rbq23)
            {
                counter ++;
            }
        }

        if(group.getId()==R.id.rg3){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq31)
            {
                counter ++;
            }
        }

        if(group.getId()==R.id.rg4){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq42)
            {
                counter ++;
            }
        }

        if(group.getId()==R.id.rg5){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq51)
            {
                counter ++;
            }
        }

        if(group.getId()==R.id.rg6){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq62)
            {
                counter ++;
            }
        }

        if(group.getId()==R.id.rg7){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq74)
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
            Intent intent = new Intent(getBaseContext(),Results_Board.class);
            intent.putExtra("score",calculatePercentage());
            intent.putExtra("string",programming());
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
