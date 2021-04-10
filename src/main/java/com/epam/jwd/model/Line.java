package com.epam.jwd.model;

import com.epam.jwd.strategy.ShapeStrategy;

import java.util.Scanner;

public class Line extends Shape implements ShapeStrategy {
    public Line(Point[] points1) {
        n = 2;
        points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = points1[1];
        }
    }

    public Line() {
        n = 2;
        points = new Point[n];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 1);
    }

    public Line(int a) {
        n = 2;
        int x, y;
        for (int i = 0; i < n; i++) {
            Scanner in = new Scanner(System.in);
            x = in.nextInt();
            y = in.nextInt();
            this.setPoint(i, x, y);
        }
    }

    @Override
    public double getPerimeter() {
        double k1=(points[0].getX()-points[1].getX())*(points[0].getX()-points[1].getX());
        double k2=(points[0].getY()-points[1].getY())*(points[0].getY()-points[1].getY());
        return  Math.pow(k1+k2, 0.5);

    }

    @Override
    public double getSquare() {
        return 0;
    }
}
