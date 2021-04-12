package com.epam.jwd.model;

public class Line extends Shape  {
    Line(Point[] points1) {
        n = 2;
        points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = points1[1];
        }
    }

    Line() {
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
