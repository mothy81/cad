package com.empro.cad;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


import androidx.annotation.NonNull;

import java.util.ArrayList;


public class PaintView extends View {

    public ArrayList<float[]> cordList = new ArrayList<>();
    public float[] singleItem = new float[4];

    public float downxpos;
    public float downypos;
    public float upxpos;
    public float upypos;
    int i;

    private Paint paint = new Paint();
    private Path path = new Path();

    public PaintView(Context context) {
        super(context);

        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(5);
        cordList.add(singleItem);
    }
    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(5);
        cordList.add(singleItem);
    }
    public PaintView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        if (Math.abs(downxpos-upxpos)>Math.abs(downypos-upypos)) {upypos=downypos;} else {upxpos=downxpos;}
        canvas.drawLine(downxpos, downypos, upxpos, upypos, paint);
        for (int j=0; j<cordList.size(); j++) {
            canvas.drawLine(cordList.get(j)[0], cordList.get(j)[1], cordList.get(j)[2], cordList.get(j)[3], paint);
        }
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
                if (Math.abs(downxpos-upxpos)>Math.abs(downypos-upypos)) {upypos=downypos;} else {upxpos=downxpos;}
                singleItem = new float[]{downxpos, downypos, upxpos, upypos};

                cordList.add(i, singleItem);
                i++;

                break;
            default:
                return false;
        }

        postInvalidate();

        return true;
    }
}