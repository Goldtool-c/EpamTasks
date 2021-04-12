package com.epam.jwd.validator;

import com.epam.jwd.exception.InvalidShapeException;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.ShapeType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ShapeValidator{
    private static final Logger LOGGER = LogManager.getLogger(ShapeValidator.class);
    private boolean isLine(Point[] points)
    {
        boolean isLine=true;
        if(points[0].equals(points[1]))
        {
            isLine=false;
        }
        return isLine;
    }
    private boolean isTriangle(Point[] points)
    {
        boolean isTriangle=true;
        double k, b;
        k=(points[0].getY()-points[1].getY())/(points[0].getX()-points[1].getX());
        b=points[0].getY()-(k*points[0].getX());
        double left = points[2].getY();
        double right = points[2].getX()*k+b;
        if(Math.abs(left-right)<0.00001)
        {
            isTriangle=false;
        }
        return isTriangle;
    }
    private boolean isSquare(Point[] points)
    {
        boolean isSquare = false;
        boolean[] squares = new boolean[4];
        int n=4;
        int counterX = 0;
        int counterY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(points[i].getX()==points[j].getX())
                {
                    counterX++;
                }
                if(points[i].getY()==points[j].getY())
                {
                    counterY++;
                }
            }
            if(counterX==2&&counterY==2)
            {
                counterX=0;
                counterY=0;
                squares[i]=true;
            }
        }
        counterX=0;
        for (int i = 0; i < n; i++) {
            if(squares[i])
            {
                counterX++;
            } else {break;}
        }
        if(counterX==4)
        {
            isSquare=true;
        }
        return isSquare;
    }
    public boolean valid(ShapeType type, Point[] points) throws InvalidShapeException {
        switch (type)
        {
            case LINE:
                return isLine(points);
            case TRIANGLE:
                return isTriangle(points);
            case SQUARE:
                return isSquare(points);
            case POLYGON:
                return true;
            default:
                LOGGER.error("Invalid shape");
                throw new InvalidShapeException("Invalid shape");
        }
    }
}
