package com.epam.jwd.model;

import com.epam.jwd.strategy.ShapeStrategy;

import java.util.Scanner;

public class Triangle extends Shape implements ShapeStrategy {
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

    @Override
    public double getPerimeter() {
        return 0;
    }

    @Override
    public double getSquare() {
        return 0;
    }
}
