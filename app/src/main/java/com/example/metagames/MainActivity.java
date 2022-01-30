package com.example.metagames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView tt = findViewById(R.id.tickToe);
        tt.setOnClickListener(this);
        ImageView f = findViewById(R.id.fifteens);
        f.setOnClickListener(this);
        ImageView rps = findViewById(R.id.RockPaperScissors);
        rps.setOnClickListener(this);
        ImageView bc = findViewById(R.id.BullsAndCows);
        bc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tickToe){
            Intent intent = new Intent(this, TickToe.class);
            startActivity(intent);
        } else if (v.getId() == R.id.fifteens){
            Intent intent = new Intent(this, Fifteens.class);
            startActivity(intent);
        } else if (v.getId() == R.id.RockPaperScissors){
            Intent intent = new Intent(this, RockPaperScissors.class);
            startActivity(intent);
        } else if (v.getId() == R.id.BullsAndCows){
            Intent intent = new Intent(this, BullsAndCows.class);
            startActivity(intent);
        }

    }
}