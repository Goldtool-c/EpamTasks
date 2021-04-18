package com.epam.jwd.model;

public class MultiAngleShape extends Shape{

    MultiAngleShape(int n)
    {
        this.points = new Point[n];
        points[0]=new Point(0,0);
        for (int i = 1; i < n; i++) {
            points[i]= new Point(this.points[i-1].getX()-((double) n/10), this.points[i-1].getY()-((double) n/5));
        }
    }
    public MultiAngleShape(Point[] points, int n)
    {
        for (int i = 0; i < n; i++) {
            this.points[i]=points[i];
        }
    }
    @Override
    public double getSquare()//only for simple polygons
    {
        double sum1=0, sum2=0;
        for (int i = 0; i <points.length-1 ; i++) {
            sum1=sum1+points[i].getX()*points[i+1].getY();
        }
        for (int i = 0; i <points.length-1 ; i++) {
            sum1=sum1+points[i].getY()*points[i+1].getX();
        }
        double square = sum1+(points[points.length-1].getX()*points[0].getY())-sum2-(points[points.length-1].getY()*points[0].getX());
        return Math.abs(square/2);
    }
}
