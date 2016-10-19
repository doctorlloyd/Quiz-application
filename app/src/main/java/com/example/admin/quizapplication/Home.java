package com.example.admin.quizapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Home extends AppCompatActivity {
    private MediaPlayer song;
    private ImageView image;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        initialize();
        song.start();
        image.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                Intent intent = new Intent(Home.this,Topics.class);
                startActivity(intent);
                finish();
            }
        });

    }
    public void initialize()
    {
        image =(ImageView)findViewById(R.id.proceedImage);
        song = MediaPlayer.create(this,R.raw.welcome);
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder progressDialog = new AlertDialog.Builder(Home.this);
        progressDialog.setMessage("Are you sure you want to exit?").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = progressDialog.create();
        alert.setTitle("You are about to exit!");
        alert.show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        song.release();
    }
}
