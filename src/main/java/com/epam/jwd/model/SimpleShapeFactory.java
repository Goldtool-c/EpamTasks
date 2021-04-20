package com.epam.jwd.model;

import com.epam.jwd.repository.ShapeStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum SimpleShapeFactory{
    GENERAL;
    private static final Logger LOGGER = LogManager.getLogger(SimpleShapeFactory.class);
    public Shape createDefaultShape(ShapeType type, int n)
    {
        int id;
        id = ShapeStorage.GENERAL.getLength();
        Shape shape;
        switch (type) {
            case LINE:
            {
                shape=new Line(id);
                break;
            }
            case TRIANGLE:
            {
                shape=new Triangle(id);
                break;
            }
            case SQUARE:
            {
                shape=new Square(id);
                break;
            }
            case POLYGON:
            {
                shape= new MultiAngleShape(n, id);
                break;
            }
            default:
            {
                LOGGER.error("Unknown Shape, returning line(0, 0), (0, 1), id: "+ id);
                shape=new Line(id);
                break;
            }
        }
        ShapeStorage.GENERAL.add(shape);
        return shape;
    }


}
