package com.example.metagames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BullsAndCows extends AppCompatActivity implements View.OnClickListener {
    int [] number = new int[4];

    int n_try = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulls_and_cows);
        Button enter = findViewById(R.id.enter);
        enter.setOnClickListener(this);
        for (int i = 0; i < 4; i ++){
            number[i] = (int)(Math.random() * 9);

        }
    }

    @Override
    public void onClick(View v) {
        TextView tries = findViewById(R.id.tries);
        TextView input_number = findViewById(R.id.input_number);
        TextView bulls_cows = findViewById(R.id.bulls_cows);
        EditText input = findViewById(R.id.input);
        String text = input.getText().toString();
        char [] number1 = text.toCharArray();
        int bulls = 0;
        int cows = 0;
        if (!text.equals("") && n_try < 14){
            n_try ++;
            tries.append(n_try + "\n\n");
            input_number.append(text + "\n\n");
            for (int i = 0; i < 4; i ++){
                int number2 = Integer.parseInt(Character.toString(number1[i]));
                for (int j = 0; j < 4; j ++){
                    if (number2 == number[j]){
                        if (i == j){
                            bulls ++;
                        } else {
                            cows ++;
                        }
                    }

                }
            }
            bulls_cows.append(bulls + "/" + cows + "\n\n");
            if (bulls == 4){
                Toast toast = Toast.makeText(this, "Победа", Toast.LENGTH_SHORT);
                toast.show();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }
        input.setText("");


    }
}