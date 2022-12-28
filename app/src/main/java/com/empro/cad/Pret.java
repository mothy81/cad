package com.empro.cad;

public class Pret {
    int number;
    float xStart;
    float yStart;
    float xEnd;
    float yEnd;
    float lenght;
    float eI;
    float eA;
    int nodeTypeStart;
    int nodeTypeEnd;

    public Pret (int number, float xStart, float yStart, float xEnd, float yEnd, float eI, float eA, int nodeTypeStart, int nodeTypeEnd)
    {
        this.number = number;
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.lenght = (float) Math.sqrt((xStart-xEnd)*(xStart-xEnd)+(yStart-yEnd)*(yStart-yEnd));
        this.eI = eI;
        this.eA = eA;
        this.nodeTypeStart = nodeTypeStart;
        this.nodeTypeEnd = nodeTypeEnd;
    }


    }

