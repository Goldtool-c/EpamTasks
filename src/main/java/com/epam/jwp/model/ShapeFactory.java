package com.epam.jwp.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapeFactory {
    private static final Logger LOGGER = LogManager.getLogger(ShapeFactory.class);

    public static Shape createShape(ShapeType type)
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
}
