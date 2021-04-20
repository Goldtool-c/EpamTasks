package com.epam.jwd.model;

import com.epam.jwd.strategy.ShapePropertiesStrategy;

public class Square extends Shape implements ShapePropertiesStrategy {

    public Square(Point[] points1, int id) {
        this.id=id;
        n=4;
        points = new Point[n];
        for (int i = 0; i < n ; i++) {
            points[i]=points1[1];
        }
    }
    Square(int id)
    {
        this.id=id;
        n=4;
        points = new Point[n];
        points[0]=new Point(0,0);
        points[1]= new Point(0,2);
        points[2]=new Point(2,2);
        points[3]= new Point(2, 0);
    }

    @Override
    public double getSquare() {
        return 4*this.getLineLength(points[1],points[2]);
    }
}
