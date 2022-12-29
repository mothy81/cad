package com.empro.cad;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

public int gridFlag;
public PaintView paintView;
Context ctx;

public Button gridButton, ortoButton, scaleButton, delButton;
public EditText xValue, yValue, gridJumpValueBox;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
        PaintView paintView = findViewById(R.id.paintView);

        ctx = getApplicationContext();

        gridButton = findViewById(R.id.gridButton);
        ortoButton = findViewById(R.id.ortoButton);
        scaleButton = findViewById(R.id.scaleButton);
        delButton = findViewById(R.id.delButton);
        gridJumpValueBox = findViewById(R.id.gridJumpValueBox);
        xValue = findViewById(R.id.xValue);
        yValue = findViewById(R.id.yValue);
        xValue.setText("15");

        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0; paintView.rodsList.size()>i;i++)
                {
                    if (paintView.rodsList.get(i).isHighlighted()){paintView.rodsList.remove(i);}
                    paintView.invalidate();
                }
            }
        });

        gridButton.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {
                if (paintView.gridFlag == 1) {paintView.gridFlag = 1;} else {paintView.gridFlag = 1;}
                paintView.gridJump = Float.valueOf(gridJumpValueBox.getText().toString());
                paintView.invalidate();
                }
                });

        ortoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (paintView.ortoFlag == 1) {paintView.ortoFlag = 0;} else {paintView.ortoFlag = 1;}
            }
        });

            }




    }
