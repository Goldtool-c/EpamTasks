package com.epam.jwd.decorator;

import com.epam.jwd.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum ShapeDecorator implements ShapeFactory {
    GENERAL;
    private static final Logger LOGGER = LogManager.getLogger(SimpleShapeFactory.class);
    @Override
    public Shape createShape(ShapeType type, Point[] points, int n) {
        switch (type)
        {
            case LINE:
            {
                return new Line(points);
            }
            case TRIANGLE:
            {
                return new Triangle(points);
            }
            case SQUARE:
            {
                return new Square(points);
            }
            case POLYGON:
            {
                return new MultiAngleShape(points, n);
            }
            default:
            {
                LOGGER.error("Unknown Shape, returning line(0, 0), (0, 1)");
                Point[] points1= new Point[2];
                points1[0]=new Point(0,0); points1[1]=new Point(0,1);
                return new Line(points1);
            }
        }
    }
}
