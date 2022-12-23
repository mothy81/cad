package com.empro.cad;

public class CordList {

        private float x1;
        private float y1;
        private float x2;
        private float y2;


        public CordList(float mx1, float my1, float mx2, float my2) {

            x1 = mx1;
            y1 = my1;
            x2 = mx2;
            y2 = my2;

        }

    public CordList(float x2) {
        this.x2 = x2;
    }

    // public void changeText2(String text) {
      //     mtext2 = text;
      // }

      // public void changeText4(String text) {
       //     mtext4 = text;
       // }



    public float getX1() {return x1;}
    public float getY1() {return y1;}
    public float getX2() {return x2;}
    public float getY2() {return y1;}









    }
