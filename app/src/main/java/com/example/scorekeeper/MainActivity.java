package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Integer scoreTeam1 = 0;
    private Integer scoreTeam2 = 0;

    private TextView scoreTeam1TextView;
    private TextView scoreTeam2TextView;

    private ImageView team1MinusButton;
    private ImageView team1PlusButton;
    private ImageView team2MinusButton;
    private ImageView team2PlusButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTeam1TextView = (TextView) findViewById(R.id.ScoreTeam1);
        scoreTeam2TextView = (TextView) findViewById(R.id.ScoreTeam2);

        if(savedInstanceState != null){
            scoreTeam1 = savedInstanceState.getInt("Score1");
            scoreTeam2 = savedInstanceState.getInt("Score2");
            scoreTeam1TextView.setText(String.valueOf(scoreTeam1));
            scoreTeam2TextView.setText(String.valueOf(scoreTeam2));
        }

        team1MinusButton = (ImageView) findViewById(R.id.MinusButtonTeam1);
        team1PlusButton = (ImageView) findViewById(R.id.PlusButtonTeam1);
        team2MinusButton = (ImageView) findViewById(R.id.MinusButtonTeam2);
        team2PlusButton = (ImageView) findViewById(R.id.PlusButtonTeam2);

        team1MinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseScore(v);
            }
        });
        team1PlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseScore(v);
            }
        });
        team2MinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseScore(v);
            }
        });
        team2PlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseScore(v);
            }
        });


    }
    private void increaseScore(View view){
        if(view.getId() == R.id.PlusButtonTeam1){
            scoreTeam1++;
            scoreTeam1TextView.setText(scoreTeam1.toString());
        }else{
            scoreTeam2++;
            scoreTeam2TextView.setText(scoreTeam2.toString());
        }
    }
    private void decreaseScore(View view){
        if(view.getId() == R.id.MinusButtonTeam1){
            if(scoreTeam1>0){
                scoreTeam1--;
            }
            scoreTeam1TextView.setText(scoreTeam1.toString());
        }else{
            if(scoreTeam2>0){
                scoreTeam2--;
            }
            scoreTeam2TextView.setText(scoreTeam2.toString());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       super.onOptionsItemSelected(item);
       if(item.getItemId() == R.id.night_mode){
           int nightMode = AppCompatDelegate.getDefaultNightMode();

           if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
               AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
           }else{
               AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
           }
           recreate();
       }
       return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();

        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Score1",scoreTeam1);
        outState.putInt("Score2",scoreTeam2);
    }

}