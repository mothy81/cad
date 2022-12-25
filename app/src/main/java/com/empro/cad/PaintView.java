package com.empro.cad;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.annotation.NonNull;

import java.util.ArrayList;


public class PaintView extends ScrollView {

    public ArrayList<float[]> cordList = new ArrayList<>();
    public float[] singleItem = new float[4];

    public Button ortoButton, gridButton, scaleButton;


    public float downxpos,downypos,upxpos,upypos,canvasWidth, canvasHeight,gridFactor, gridJump=1;


    int i,gridFlag=1, ortoFlag;

    private Paint paintLine = new Paint();
    private Paint paintNode = new Paint();
    private Paint paintDot = new Paint();



    public PaintView(Context context) {
        super(context);


    }
    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paintLine.setColor(Color.BLACK);
        paintLine.setStrokeWidth(4);

        paintNode.setColor(Color.RED);
        paintNode.setStrokeWidth(5);

        paintDot.setColor(Color.GRAY);
        paintDot.setStrokeWidth(3);

        cordList.add(singleItem);

        ortoButton = findViewById(R.id.ortoButton);
        gridButton = findViewById(R.id.gridButton);
        scaleButton = findViewById(R.id.scaleButton);



        ;

    }
    public PaintView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    protected void onDraw(Canvas canvas) {


        if (ortoFlag == 1){
            if (Math.abs(downxpos-upxpos)>Math.abs(downypos-upypos)) {upypos=downypos;} else {upxpos=downxpos;}
        }

        canvas.drawLine(downxpos, downypos, upxpos, upypos, paintLine);
        for (int j=0; j<cordList.size(); j++) {

            canvas.drawLine(cordList.get(j)[0], cordList.get(j)[1], cordList.get(j)[2], cordList.get(j)[3], paintLine);
            canvas.drawCircle(cordList.get(j)[0], cordList.get(j)[1],10,paintNode);
            canvas.drawCircle(cordList.get(j)[2], cordList.get(j)[3],10,paintNode);
        }

        canvasWidth = getWidth();
        canvasHeight = getHeight();
        gridFactor = 100*gridJump;
        for (int ii=0; ii<canvasWidth/gridFactor; ii++){
            for (int k=0; k<canvasHeight/gridFactor; k++){
                canvas.drawPoint(ii*gridFactor,k*gridFactor,paintDot);}}



    }




    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downxpos = event.getX();
                downypos = event.getY();

            case MotionEvent.ACTION_MOVE:
                upxpos = event.getX();
                upypos = event.getY();

                break;
            case MotionEvent.ACTION_UP:
                if (ortoFlag == 1){
                if (Math.abs(downxpos-upxpos)>Math.abs(downypos-upypos)) {upypos=downypos;} else {upxpos=downxpos;}
                    }

                if (gridFlag == 1) {
                    downxpos = Math.round(downxpos / gridFactor) * gridFactor;
                    downypos = Math.round(downypos / gridFactor) * gridFactor;
                    upypos = Math.round(upypos / gridFactor) * gridFactor;
                    upxpos = Math.round(upxpos / gridFactor) * gridFactor;
                }

                singleItem = new float[]{downxpos, downypos, upxpos, upypos};

                cordList.add(i, singleItem);
                i++;

                break;
            default:
                return false;
        }

        invalidate();

        return true;
    }
}