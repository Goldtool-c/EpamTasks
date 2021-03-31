package com.epam.jwp.model;
import com.epam.jwp.exceptions.ShapeDoesNotExistException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Shape {
    protected Point[] points;
    protected int n;
    protected static final Logger LOGGER = LogManager.getLogger(Shape.class);
    public Point getPoint(int n)
    {
        return points[n];
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
    public boolean isShape()
    {
        boolean isShape=true;
        for (int i = 1; i < n ; i++) {
            if(points[i-1].equals(points[i])){
                isShape=false;
                break;
            }
        }
        return isShape;
    }
    public static void printShape(Shape[] shapes) throws ShapeDoesNotExistException
    {
        for (int j = 0; j < shapes.length; j++) {
            if(shapes[j].isShape()&&shapes[j].isThisShape())
            {
                LOGGER.info(j+1+"st "+shapes[j].getClass().getSimpleName()+": "+shapes[j]);
            }
            else if(!shapes[j].isShape())
            {
                LOGGER.error(j+1+"st element isn't a shape");
                throw new ShapeDoesNotExistException("This is not a shape");
            } else
            {
                LOGGER.error(j+1+"st element isn't a "+shapes[j].getClass().getSimpleName());
                throw new ShapeDoesNotExistException("This is not a "+shapes[j].getClass().getSimpleName());
            }
        }
    }

    public abstract boolean isThisShape();

    //public abstract boolean isLine();
}
