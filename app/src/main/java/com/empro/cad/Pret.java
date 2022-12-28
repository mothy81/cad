package com.empro.cad;

public class Pret {
    float xStart;
    float yStart;
    float xEnd;
    float yEnd;
    float lenght;
    float eI=1;
    float eA=1;
    int nodeTypeStart=0;

    public boolean isHighlighted() {
        return highlighted;
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }

    int nodeTypeEnd=0;
    boolean highlighted=false;

    public float getxStart() {
        return xStart;
    }

    public float getyStart() {
        return yStart;
    }

    public float getxEnd() {
        return xEnd;
    }

    public float getyEnd() {
        return yEnd;
    }

    public float getLenght() {
        return lenght;
    }

    public float geteI() {
        return eI;
    }

    public float geteA() {
        return eA;
    }

    public int getNodeTypeStart() {
        return nodeTypeStart;
    }

    public int getNodeTypeEnd() {
        return nodeTypeEnd;
    }

    public void setxStart(float xStart) {
        this.xStart = xStart;
    }

    public void setyStart(float yStart) {
        this.yStart = yStart;
    }

    public void setxEnd(float xEnd) {
        this.xEnd = xEnd;
    }

    public void setyEnd(float yEnd) {
        this.yEnd = yEnd;
    }

    public void seteI(float eI) {
        this.eI = eI;
    }

    public void seteA(float eA) {
        this.eA = eA;
    }

    public void setNodeTypeStart(int nodeTypeStart) {
        this.nodeTypeStart = nodeTypeStart;
    }

    public void setNodeTypeEnd(int nodeTypeEnd) {
        this.nodeTypeEnd = nodeTypeEnd;
    }

    public Pret (float xStart, float yStart, float xEnd, float yEnd, float eI, float eA, int nodeTypeStart, int nodeTypeEnd, boolean swichSides,boolean highlighted)
    {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.lenght = (float) Math.sqrt((xStart-xEnd)*(xStart-xEnd)+(yStart-yEnd)*(yStart-yEnd));
        this.eI = eI;
        this.eA = eA;
        this.nodeTypeStart = nodeTypeStart;
        this.nodeTypeEnd = nodeTypeEnd;
        this.highlighted = highlighted;
    }


    }

