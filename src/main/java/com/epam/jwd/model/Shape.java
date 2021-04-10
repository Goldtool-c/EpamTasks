package com.epam.jwd.model;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Shape {
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

    public static void printShapes(Shape[] shapes)
    {
        for (int j = 0; j < shapes.length; j++) {
                LOGGER.info(j+1+"st "+shapes[j].getClass().getSimpleName()+": "+shapes[j]);
        }
    }
}
