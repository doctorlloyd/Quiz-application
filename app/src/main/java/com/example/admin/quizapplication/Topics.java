package com.example.admin.quizapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Topics extends Activity {
    private ListView list;
    private ArrayList<String> array = new ArrayList<String>();
    private String message;
    private MediaPlayer song;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topics);
        initialize();
        song.start();
        populate();
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0)
                {
                    Intent intent = new Intent(getBaseContext(),Politics.class);
                    intent.putExtra("topic","POLITICS");
                    startActivity(intent);
                    finish();
                }else if(position == 1)
                {
                    Intent intent = new Intent(getBaseContext(),Mathematics.class);
                    intent.putExtra("topic","MATHEMATICS");
                    startActivity(intent);
                    finish();
                }else if(position == 2)
                {
                    Intent intent = new Intent(getBaseContext(),Networking.class);
                    intent.putExtra("topic","IT NETWORKING");
                    startActivity(intent);
                    finish();
                }else if(position == 3)
                {
                    Intent intent = new Intent(getBaseContext(),Programming.class);
                    intent.putExtra("topic","IT PROGRAMMING");
                    startActivity(intent);
                    finish();
                }else if(position == 4)
                {
                    Intent intent = new Intent(getBaseContext(),Cars.class);
                    intent.putExtra("topic","CARS");
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getBaseContext(),Home.class);
        startActivity(intent);
        finish();
    }
    public void initialize()
    {
        song = MediaPlayer.create(Topics.this,R.raw.moment);
        list = (ListView)findViewById(R.id.topicList);
    }
    public void populate()
    {
        message = "POLITICS";
        array.add(message);
        message = "MATHEMATICS";
        array.add(message);
        message = "IT NETWORKING";
        array.add(message);
        message = "IT PROGRAMMING";
        array.add(message);
        message = "CARS";
        array.add(message);
    }
    @Override
    protected void onResume(){
        super.onResume();
        song.release();
    }
}
