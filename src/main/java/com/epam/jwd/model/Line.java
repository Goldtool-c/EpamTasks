package com.epam.jwd.model;

public class Line extends Shape  {
    public Line(Point[] points1, int id) {
        this.id=id;
        n = 2;
        points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = points1[1];
        }
    }

    Line(int id) {
        this.id=id;
        n = 2;
        points = new Point[n];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 1);
    }

    @Override
   public double getPerimeter()
   {
       return this.getLineLength(points[1], points[0]);
   }
}
