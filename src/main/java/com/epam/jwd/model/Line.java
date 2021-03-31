package com.epam.jwd.model;

import com.epam.jwd.strategy.ThisShapeStrategy;

import java.util.Scanner;

public class Line extends Shape implements ThisShapeStrategy {
    public Line(Point[] points1)
    {
        n=2;
        points = new Point[n];
        for (int i = 0; i < n ; i++) {
            points[i]=points1[1];
        }
    }
    public Line()
    {
        n=2;
        points = new Point[n];
        points[0] = new Point(0,0);
        points[1] = new Point(0,1);
    }
    public Line(int a)
    {
        n=2;
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
        boolean isLine=true;
        if(this.points[0].equals(this.points[1]))
        {
            isLine=false;
        }
        return isLine;
    }
}
