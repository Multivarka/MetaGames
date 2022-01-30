package com.example.metagames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Space extends AppCompatActivity implements View.OnTouchListener{
    boolean leftPressed = false;
    boolean rightPressed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space);
        Button leftButton = findViewById(R.id.leftB);
        Button rightButton = findViewById(R.id.rightB);
        leftButton.setOnTouchListener(this);
        rightButton.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch(v.getId()) { // определяем какая кнопка
            case R.id.leftB:
                switch (event.getAction()) { // определяем нажата или отпущена
                    case MotionEvent.ACTION_DOWN:
                        leftPressed = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        leftPressed = false;
                        break;
                }
                break;
            case R.id.rightB:
                switch (event.getAction()) { // определяем нажата или отпущена
                    case MotionEvent.ACTION_DOWN:
                        rightPressed = true;
                        break;
                    case MotionEvent.ACTION_UP:
                        rightPressed = false;
                        break;
                }
                break;
        }
        return true;
    }
}

class Ship{

}