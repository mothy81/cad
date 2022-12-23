package com.empro.cad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
public ArrayList<int[]> cordList;
public int[] singleItem;
PaintView paintView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       PaintView paintView = new PaintView(this);

        EditText xValue, yValue;
        xValue = findViewById(R.id.xValue);
        yValue = findViewById(R.id.yValue);
        xValue.setText("0");



    }
}