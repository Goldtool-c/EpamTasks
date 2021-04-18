package com.epam.jwd.model;

import com.epam.jwd.strategy.ShapePropertiesStrategy;

public class Triangle extends Shape implements ShapePropertiesStrategy {
    public Triangle(Point[] points1) {
        n=3;
        points = new Point[n];
        for (int i = 0; i < n ; i++) {
            points[i]=points1[1];
        }
    }
    Triangle()
    {
        n=3;
        points = new Point[n];
        points[0] = new Point(0,0);
        points[1] = new Point(0,1);
        points[2] = new Point(1,0);
    }

    @Override
    public double getSquare() {
        double p = this.getPerimeter()/2;
        double[] a= new double[3];
        for (int i = 1; i < 3; i++) {
            a[i]=this.getLineLength(points[i], points[i-1]);
        }
        a[0]=this.getLineLength(points[0], points[points.length-1]);
        double square = Math.pow(p*(p-a[0])*(p-a[1])*(p-a[2]), 0.5);
        return square;
    }
}
