package com.example.metagames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class TickToe extends AppCompatActivity implements View.OnClickListener {

    String sym = "X";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tick_toe);
        makeButtons();


    }

    @Override
    public void onClick(View v) {
        Button[] buttons = makeButtons();
        place(v.getId(), buttons);
        win();

    }

    Button[] makeButtons(){
        Button[] buttons = new Button[9];
        buttons[0] = findViewById(R.id.button);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button4);
        buttons[4] = findViewById(R.id.button5);
        buttons[5] = findViewById(R.id.button6);
        buttons[6] = findViewById(R.id.button7);
        buttons[7] = findViewById(R.id.button8);
        buttons[8] = findViewById(R.id.button9);
        for (int i = 0; i < 9; i ++){
            buttons[i].setOnClickListener(this);
        }
        return buttons;
    }
    void place(int id, Button[] buttons){
        switch (id) {
            case R.id.button:
                if(buttons[0].getText() == "") {
                    buttons[0].setText(sym);
                    if (sym == "X"){
                        sym = "O";
                    } else {
                        sym = "X";
                    }
                }
                break;
            case R.id.button2:
                if(buttons[1].getText() == "") {
                    buttons[1].setText(sym);
                    if (sym == "X"){
                        sym = "O";
                    } else {
                        sym = "X";
                    }
                }
                break;
            case R.id.button3:
                if(buttons[2].getText() == "") {
                    buttons[2].setText(sym);
                    if (sym == "X"){
                        sym = "O";
                    } else {
                        sym = "X";
                    }
                }
                break;
            case R.id.button4:
                if(buttons[3].getText() == "") {
                    buttons[3].setText(sym);
                    if (sym == "X"){
                        sym = "O";
                    } else {
                        sym = "X";
                    }
                }
                break;
            case R.id.button5:
                if(buttons[4].getText() == "") {
                    buttons[4].setText(sym);
                    if (sym == "X"){
                        sym = "O";
                    } else {
                        sym = "X";
                    }

                }
                break;
            case R.id.button6:
                if(buttons[5].getText() == "") {
                    buttons[5].setText(sym);
                    if (sym == "X"){
                        sym = "O";
                    } else {
                        sym = "X";
                    }
                }
                break;
            case R.id.button7:
                if(buttons[6].getText() == "") {
                    buttons[6].setText(sym);
                    if (sym == "X"){
                        sym = "O";
                    } else {
                        sym = "X";
                    }
                }
                break;
            case R.id.button8:
                if(buttons[7].getText() == "") {
                    buttons[7].setText(sym);
                    if (sym == "X"){
                        sym = "O";
                    } else {
                        sym = "X";
                    }
                }
                break;
            case R.id.button9:
                if(buttons[8].getText() == "") {
                    buttons[8].setText(sym);
                    if (sym == "X"){
                        sym = "O";
                    } else {
                        sym = "X";
                    }
                }
                break;
        }

    }
    void win(){
        Button[] buttons = makeButtons();
        Toast toast = Toast.makeText(this, "Победа", Toast.LENGTH_SHORT);
        if ((buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X") ||
                buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O"){
            toast.show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if ((buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X") ||
                buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O"){
            toast.show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if ((buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X") ||
                buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O"){
            toast.show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if ((buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X") ||
                buttons[0].getText() == "O" && buttons[3].getText() == "O" && buttons[6].getText() == "O"){
            toast.show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if ((buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X") ||
                buttons[1].getText() == "O" && buttons[4].getText() == "O" && buttons[7].getText() == "O"){
            toast.show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if ((buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X") ||
                buttons[2].getText() == "O" && buttons[5].getText() == "O" && buttons[8].getText() == "O"){
            toast.show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if ((buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X") ||
                buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O"){
            toast.show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if ((buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X") ||
                buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O"){
            toast.show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }
}
