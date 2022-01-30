package com.example.metagames;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RockPaperScissors extends AppCompatActivity implements View.OnClickListener {
    final Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);
        Button button = findViewById(R.id.play);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int[] choises = new int[0];
        try {
            choises = choose();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        win(choises);
    }

    int[] choose() throws InterruptedException {
        TextView player1 = findViewById(R.id.player1);
        TextView player2 = findViewById(R.id.player2);
        ImageView pl2 = findViewById(R.id.imageView2);
        ImageView pl1 = findViewById(R.id.imageView3);
        int p1 = random.nextInt(3) + 1;
        int p2 = random.nextInt(3) + 1;
        int[] players = new int[2];
        players[0] = p1;
        players[1] = p2;
        Thread.sleep(1000);
        switch (p1){
            case 1:
                player1.setText("Камень");
                pl1.setImageResource(R.drawable.rock);
                break;
            case 2:
                player1.setText("Ножницы");
                pl1.setImageResource(R.drawable.scissors);
                break;
            case 3:
                player1.setText("Бумага");
                pl1.setImageResource(R.drawable.paper);
                break;
        }
        switch (p2){
            case 1:
                player2.setText("Камень");
                pl2.setImageResource(R.drawable.rock);
                break;
            case 2:
                player2.setText("Ножницы");
                pl2.setImageResource(R.drawable.scissors);
                break;
            case 3:
                player2.setText("Бумага");
                pl2.setImageResource(R.drawable.paper);
                break;
        }
        return players;
    }

    void win(int[] choises){
        if (choises[0] == choises[1]){
            Toast toast = Toast.makeText(this, "Ничья", Toast.LENGTH_SHORT);
            toast.show();
        } else if ((choises[0] == 1 && choises[1] == 2) || (choises[0] == 2 && choises[1] == 3) || (choises[0] == 3 && choises[1] == 1)){
            Toast toast = Toast.makeText(this, "Победил игрок 1", Toast.LENGTH_SHORT);
            toast.show();
        } else if ((choises[1] == 1 && choises[0] == 2) || (choises[1] == 2 && choises[0] == 3) || (choises[1] == 3 && choises[0] == 1)){
            Toast toast = Toast.makeText(this, "Победил игрок 2", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}