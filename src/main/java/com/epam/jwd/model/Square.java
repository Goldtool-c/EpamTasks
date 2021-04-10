package com.epam.jwd.model;

import com.epam.jwd.strategy.ShapeStrategy;

import java.util.Scanner;

public class Square extends Shape implements ShapeStrategy {

    public Square(Point []points1) {
        n=4;
        points = new Point[n];
        for (int i = 0; i < n ; i++) {
            points[i]=points1[1];
        }
    }
    public Square()
    {
        n=4;
        points = new Point[n];
        points[0]=new Point(0,0);
        points[1]= new Point(0,2);
        points[2]=new Point(2,2);
        points[3]= new Point(2, 0);
    }
    public Square(int a)
    {
        n=4;
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
