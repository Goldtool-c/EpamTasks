package com.epam.jwd.factory;

import com.epam.jwd.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapeFactory {
    private static final Logger LOGGER = LogManager.getLogger(ShapeFactory.class);

    public static Shape createDefaultShape(ShapeType type)
    {
        Shape shape = null;
        switch (type) {
            case LINE:
            {
                shape=new Line();
                break;
            }
            case TRIANGLE:
            {
                shape=new Triangle();
                break;
            }
            case SQUARE:
            {
                shape=new Square();
                break;
            }
            default:
            {
                LOGGER.error("Unknown Shape, returning line(0, 0), (0, 1)");
                shape=new Line();
                break;
            }
        }
        return shape;
    }
    public Shape createShape(ShapeType type, Point[] points)
    {
        Shape shape = null;
        switch (type) {
            case LINE:
            {
                shape=new Line(points);
                break;
            }
            case TRIANGLE:
            {
                shape=new Triangle(points);
                break;
            }
            case SQUARE:
            {
                shape=new Square(points);
                break;
            }
            default:
            {
                LOGGER.error("Unknown Shape, returning line(0, 0), (0, 1)");
                shape=new Line();
                break;
            }
        }
        return shape;
    }
}
