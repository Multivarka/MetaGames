package com.example.metagames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Miner extends AppCompatActivity {

    private int COLS;
    private int ROWS;
    private int MINES;
    private int[][] field;


    int calcNear(int x, int y) {
        int i = 0;
        for (int offsetX = -1; offsetX <= 1; offsetX++) {
            for (int offsetY = -1; offsetY <= 1; offsetY++) {
                if (outBounds(offsetX+x, offsetY + y)) continue;
                i += field[offsetX+x][offsetY+y];
            }
        }
        return i;
    }

    boolean outBounds(int x, int y){
        return x < 0 || y < 0 || x >= COLS || y >= ROWS;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miner);
        Intent intent = getIntent();
        COLS = intent.getIntExtra("columns", 5);
        ROWS = intent.getIntExtra("rows", 7);
        MINES = intent.getIntExtra("mines", 5);
        field = new int[ROWS][COLS];
        for (int y = 0; y < ROWS; y ++){
            for (int x = 0; x < COLS; x ++){

                calcNear(x, y);
            }
        }

    }
}