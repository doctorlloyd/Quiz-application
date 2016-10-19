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
public class Networking extends Activity implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup rg1,rg2,rg3,rg4,rg5,rg6,rg7,rg8,rg9,rg10;
    private TextView tvTopic;
    private int counter;
    private ArrayList<String> answers = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.networking);
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
        rg10 = (RadioGroup)findViewById(R.id.rg10);

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
        rg10.setOnCheckedChangeListener(this);
    }
    public String networking() {
        String str = "Q: How long is an IPv6 address?;Answer: Option D" +
                "@Q: What flavor of Network Address Translation can be used to have one IP address allow many users to connect to the global Internet?;Answer: Option D" +
                "@Q: What are the two main types of access control lists (ACLs)? 1.Standard, 2.IEEE, 3.Extended, 4.Specialized;Answer: Option A" +
                "@Q: What command is used to create a backup configuration?;Answer: Option B" +
                "@Q: You have 10 users plugged into a hub running 10Mbps half-duplex. There is a server connected to the switch running 10Mbps half-duplex as well. How much bandwidth does each host have to the server?;Answer: Option D" +
                "@Q: Which of the following is the valid host range for the subnet on which the IP address 192.168.168.188 255.255.255.192 resides?;Answer: Option A" +
                "@Q: What protocol does PPP use to identify the Network layer protocol?;Answer: Option A" +
                "@Q: Which of the following commands will allow you to set your Telnet password on a Cisco router?;Answer: Option C" +
                "@Q: Which protocol does DHCP use at the Transport layer?;Answer: Option C" +
                "@Q: To back up an IOS, what command will you use?;Answer: Option D";
        return str;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId){

        if(group.getId()==R.id.rg1){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq14)
            {
                counter ++;
            }
        }

        if(group.getId()==R.id.rg2){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq24)
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
            if(checkedId==R.id.rbq54)
            {
                counter ++;
            }
        }

        if(group.getId()==R.id.rg6){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq61)
            {
                counter ++;
            }
        }

        if(group.getId()==R.id.rg7){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq71)
            {
                counter ++;
            }
        }

        if(group.getId()==R.id.rg8){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq83)
            {
                counter ++;
            }
        }

        if(group.getId()==R.id.rg9){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq93)
            {
                counter ++;
            }
        }

        if(group.getId()==R.id.rg10){
            answers.add(((RadioButton) findViewById(group.getCheckedRadioButtonId())).getText().toString());
            if(checkedId==R.id.rbq104)
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
        if(answers.size()>=10) {
            Intent intent = new Intent(getBaseContext(),Results_Board.class);
            intent.putExtra("score",calculatePercentage());
            intent.putExtra("string",networking());
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
        double percentage = (counter/10) * 100;
        return  percentage;
    }
}
