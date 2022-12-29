package com.empro.cad;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;


public class PaintView extends ScrollView {

    public ArrayList<Pret> rodsList = new ArrayList<>();
    //public Pret pret = new Pret(200f,300f,800f,500f,8f,9f,2,2,false,false);
    public Button ortoButton, gridButton, scaleButton;
    public float downxpos,downypos,upxpos,upypos,canvasWidth, canvasHeight,gridFactor, gridJump=1;
    int i,gridFlag=1, ortoFlag;
    Boolean isLongClickPressed = false;

    private Paint paintLine = new Paint();
    private Paint paintNode = new Paint();
    private Paint paintDot = new Paint();

    public PaintView(Context context) {
        super(context);

    }
    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paintInit();
        viewsInit();

    }

    public PaintView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    protected void onDraw(Canvas canvas) {

        if (ortoFlag == 1){
            ortoInit();
        }
        if (isLongClickPressed){
            // TODO LongClickPressed Action on canvas
        }

        canvas.drawLine(downxpos, downypos, upxpos, upypos, paintLine);

        for (int j=0; j<rodsList.size(); j++) {
            if (rodsList.get(j).isHighlighted()){
                paintLine.setStrokeWidth(8);
                paintLine.setColor(Color.RED);}
            canvas.drawLine(rodsList.get(j).getxStart(), rodsList.get(j).getyStart(), rodsList.get(j).getxEnd(), rodsList.get(j).getyEnd(), paintLine);
            canvas.drawCircle(rodsList.get(j).getxStart(), rodsList.get(j).getyStart(),10,paintNode);
            canvas.drawCircle(rodsList.get(j).getxEnd(), rodsList.get(j).getyEnd(),10,paintNode);
            paintLine.setStrokeWidth(5);
            paintLine.setColor(Color.BLACK);
            rodsList.get(j).setHighlighted(false);



        }

        canvasWidth = getWidth();
        canvasHeight = getHeight();
        gridFactor = 100*gridJump;
        for (int ii=0; ii<canvasWidth/gridFactor; ii++){
            for (int k=0; k<canvasHeight/gridFactor; k++){
                canvas.drawPoint(ii*gridFactor,k*gridFactor,paintDot);}}

        drawShape(canvas);
    }

    private void ortoInit() {
        if (Math.abs(downxpos-upxpos)>Math.abs(downypos-upypos)) {upypos=downypos;} else {upxpos=downxpos;}
    }

    public Canvas drawShape(Canvas canvas) {
        //TODO canvas metod;
        return null;
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
                if (downxpos==upxpos&&downypos==upypos&&(event.getEventTime() - event.getDownTime()) > 1000){
                    // TODO longClick ActionMove
                    isLongClickPressed = true;
                    downxpos = Math.round(downxpos);
                    downypos = Math.round(downypos);
                    if (downxpos == rodsList.get(0).getxStart() && downypos == rodsList.get(0).getyStart()) {

                    }


                }else


                break;
            case MotionEvent.ACTION_UP:

                if (ortoFlag == 1){
                    ortoInit();
                }


                if (downxpos==upxpos&&downypos==upypos){
                    // TODO Click UpAction

                    for (i=0; i<rodsList.size();i++) {
                        float x1=rodsList.get(i).getxStart();
                        float x2=rodsList.get(i).getxEnd();
                        float y1=rodsList.get(i).getyStart();
                        float y2=rodsList.get(i).getyEnd();
                        float x=downxpos;
                        float y=downypos;

                        double distanceToRod = (Math.abs((y2-y1)/(x2-x1)*x-y+(x2*y1-x1*y2)/(x2-x1)))/(Math.sqrt((y2-y1)/(x2-x1)*(y2-y1)/(x2-x1+1)));
                        if (distanceToRod<25){
                            rodsList.get(i).setHighlighted(true);
                            break;
                        }
                    }



                }else
                {
                    if (gridFlag == 1) {
                        downxpos = Math.round(downxpos / gridFactor) * gridFactor;
                        downypos = Math.round(downypos / gridFactor) * gridFactor;
                        upypos = Math.round(upypos / gridFactor) * gridFactor;
                        upxpos = Math.round(upxpos / gridFactor) * gridFactor;
                    }
                Pret pret = new Pret(downxpos,downypos,upxpos,upypos,8f,9f,2,2,false,false);
                rodsList.add(i, pret);
                i++;
                isLongClickPressed = false;
                }

                break;
            default:
                return false;
        }

        invalidate();

        return true;
    }

    private void paintInit() {
        paintLine.setColor(Color.BLACK);
        paintLine.setStrokeWidth(4);

        paintNode.setColor(Color.BLUE);
        paintNode.setStrokeWidth(5);

        paintDot.setColor(Color.GRAY);
        paintDot.setStrokeWidth(4);
    }

    private void viewsInit() {
        ortoButton = findViewById(R.id.ortoButton);
        gridButton = findViewById(R.id.gridButton);
        scaleButton = findViewById(R.id.scaleButton);
    }
}