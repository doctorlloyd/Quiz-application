package com.example.admin.quizapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2016/10/17.
 */
public class Mathematics extends Activity implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup rg1,rg2,rg3,rg4,rg5,rg6,rg7;
    private ArrayList<String> answers = new ArrayList<String>();
    private TextView tvTopic;
    private int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathematics);
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
    public String mathematics() {
        String str = "Q: 2x + 1 = 0 + x, solve for x;Correct Answer: x = -1"
                + "@Q: Given 2x + y = 3 + x. If x = 3, what is the value of y?;Correct Answer: y = 3"
                + "@Q: Factorise: 5(a−2)−b(2−a)?;Correct Answer: 5(a−2)−b(2−a) \n"+"=> 5(a−2)−[−b(a−2)] \n"+"=> 5(a−2)+b(a−2)\n"+" =>(a−2)(5+b)"
                + "@Q: 2/6 + 2/4 =?;Correct Answer: 1/6"
                + "@Q: (2+2) * 4 + 16/8 - 1 =;Correct Answer: 17"
                + "@Q: Solve for X, x + 8x = 4x + 20 =;Correct Answer: 4";
        return str;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if(group.getId()==R.id.rg1){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq14)
                counter++;
        }

        if(group.getId()==R.id.rg2){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq23)
                counter ++;
        }

        if(group.getId()==R.id.rg3){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq32)
                counter ++;
        }

        if(group.getId()==R.id.rg4){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq42)
                counter ++;
        }

        if(group.getId()==R.id.rg5){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq54)
                counter ++;
        }

        if(group.getId()==R.id.rg6){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq63)
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
        Intent intent = new Intent(getBaseContext(),Results_Board.class);
        intent.putExtra("score",calculatePercentage());
        intent.putExtra("string",mathematics());
        intent.putStringArrayListExtra("answers", answers);
        startActivity(intent);
        finish();
    }

    public double calculatePercentage()
    {
        double percentage = (counter/6) * 100;
        return  percentage;
    }
}
