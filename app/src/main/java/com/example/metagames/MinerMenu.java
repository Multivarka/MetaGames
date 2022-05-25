package com.example.metagames;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class MinerMenu extends AppCompatActivity implements OnClickListener{

    private static final int COLUMNS_MIN = 2;
    private static final int ROWS_MIN = 2;

    private static final int COLUMNS_MAX = 13;
    private static final int ROWS_MAX = 18;

    private static final int ALERT_NONE = 0;
    private static final int ALERT_COLUMNS = 1;
    private static final int ALERT_ROWS = 2;
    private static final int ALERT_MINES = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miner_menu);
        Button mButton = findViewById(R.id.submit);
        mButton.setOnClickListener(this);
        EditText rowsEditor = findViewById(R.id.editRows);
        EditText colsEditor = findViewById(R.id.editColumns);
        EditText minesEditor = findViewById(R.id.editMines);
        colsEditor.setText("5");
        rowsEditor.setText("7");
        minesEditor.setText("5");
    }

    private int checkInputParameters(int cols, int rows, int mines) {
        if (cols < COLUMNS_MIN || cols > COLUMNS_MAX) {
            return ALERT_COLUMNS;
        }

        if (rows < ROWS_MIN || rows > ROWS_MAX) {
            return ALERT_ROWS;
        }

        if (mines > rows * cols) {
            return ALERT_MINES;
        }

        return ALERT_NONE;

    }

    @Override
    public void onClick(View v) {
        EditText rowsEditor = findViewById(R.id.editRows);
        EditText colsEditor = findViewById(R.id.editColumns);
        EditText minesEditor = findViewById(R.id.editMines);
        int cols = Integer.parseInt(colsEditor.getText().toString());
        int rows = Integer.parseInt(rowsEditor.getText().toString());
        int mines = Integer.parseInt(minesEditor.getText().toString());
        int alertCode = checkInputParameters(cols, rows, mines);
        if (alertCode != ALERT_NONE) {
            showDialog(alertCode);
            return;
        }
        Intent intent = new Intent();

        intent.setClass(this, Miner.class);
        intent.putExtra("columns", cols);
        intent.putExtra("rows", rows);
        intent.putExtra("mines", mines);
        startActivity(intent);
        finish();

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        DialogInterface.OnClickListener doNothing = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        };
        String alertMessage;
        switch (id){
            case ALERT_COLUMNS:
                alertMessage = "Ошибка в поле 'колонны'";
                break;

            case ALERT_ROWS:
                alertMessage = "Ошибка в поле 'строки'";
                break;

            case ALERT_MINES:
                alertMessage = "Ошибка в поле 'мины'";
                break;

            default:
                return null;
        }
        return new AlertDialog.Builder(this).setMessage(alertMessage).setNeutralButton("Ок", doNothing).create();

    }
}