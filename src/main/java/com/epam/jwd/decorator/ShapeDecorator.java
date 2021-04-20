package com.epam.jwd.decorator;

import com.epam.jwd.model.*;
import com.epam.jwd.repository.ShapeStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum ShapeDecorator implements ShapeFactory {
    GENERAL;
    private static final Logger LOGGER = LogManager.getLogger(SimpleShapeFactory.class);
    @Override
    public Shape createShape(ShapeType type, Point[] points, int n) {
        Shape shape;
        int id = ShapeStorage.GENERAL.getLength();
        switch (type)
        {
            case LINE:
            {
                shape = new Line(points, id);
            }
            case TRIANGLE:
            {
                shape = new Triangle(points, id);
            }
            case SQUARE:
            {
                shape = new Square(points, id);
            }
            case POLYGON:
            {
                shape = new MultiAngleShape(points, n, id);
            }
            default:
            {
                LOGGER.error("Unknown Shape, returning line(0, 0), (0, 1)");
                Point[] points1= new Point[2];
                points1[0]=new Point(0,0); points1[1]=new Point(0,1);
                shape = new Line(points1, id);
            }
            ShapeStorage.GENERAL.add(shape);
            return shape;
        }
    }
}
