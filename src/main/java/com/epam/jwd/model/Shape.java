package com.epam.jwd.model;
import com.epam.jwd.strategy.ShapePropertiesStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Shape implements ShapePropertiesStrategy{
    protected Point[] points;
    protected int n;
    protected static final Logger LOGGER = LogManager.getLogger(Shape.class);
    public Point getPoint(int n)
    {
        return points[n];
    }
    public Point[] getPoints()
    {
        return points;
    }
    @Override
    public String toString() {
        String[] str = new String[n];
        int i=1;
        str[0] = points[i].toString()+", ";
        while(i<n)
        {
            str[i]=points[i].toString()+", "+str[i-1];
            i++;
        }
        return str[n-1];
    }
    public void setPoint(int n, double x, double y)
    {
        points[n].setX(x);
        points[n].setY(y);
    }
    public double getLineLength(Point point1, Point point2)
    {
        double k1 = point1.getX()*point1.getX()+point1.getY()+point1.getY();
        double k2 = point2.getX()*point2.getX()+point2.getY()+point2.getY();
        return Math.pow(k1+k2,0.5);
    }
    public static void printShapes(Shape[] shapes)
    {
        for (int j = 0; j < shapes.length; j++) {
                LOGGER.info(j+1+"st "+shapes[j].getClass().getSimpleName()+": "+shapes[j]);
        }
    }

    @Override
    public double getPerimeter() {
        double perimeter = 0;
        for (int i = 1; i <points.length ; i++) {

            perimeter= perimeter+this.getLineLength(points[i], points[i-1]);
        }
        perimeter=+this.getLineLength(points[0], points[points.length-1]);
        return perimeter;
    }

    @Override
    public double getSquare() {
        return 0;
    }
}
