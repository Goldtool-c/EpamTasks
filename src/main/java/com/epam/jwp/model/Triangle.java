package com.epam.jwp.model;

import com.epam.jwp.strategy.ThisShapeStrategy;

import java.util.Scanner;

public class Triangle extends Shape implements ThisShapeStrategy {
    public Triangle(Point[] points1) {
        n=3;
        points = new Point[n];
        for (int i = 0; i < n ; i++) {
            points[i]=points1[1];
        }
    }
    public Triangle()
    {
        n=3;
        points = new Point[n];
        points[0] = new Point(0,0);
        points[1] = new Point(0,1);
        points[2] = new Point(1,0);
    }
    public Triangle(int a)
    {
        n=3;
        int x,y;
        for (int i = 0; i < n ; i++) {
            Scanner in = new Scanner(System.in);
            x = in.nextInt();
            y = in.nextInt();
            this.setPoint(i, x, y);
        }

    }
    public boolean isThisShape()
    {
        boolean isTriangle=true;
        double k, b;
        k=(points[0].getY()-points[1].getY())/(points[0].getX()-points[1].getX());
        b=points[0].getY()-(k*points[0].getX());
        double left = points[2].getY();
        double right = points[2].getX()*k+b;
        if(Math.abs(left-right)<0.00001)
        {
            isTriangle=false;
        }
        return isTriangle;
    }

}
