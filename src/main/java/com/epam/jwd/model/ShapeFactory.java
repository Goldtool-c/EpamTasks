package com.epam.jwd.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public enum ShapeFactory {
    GENERAL;
    private static final Logger LOGGER = LogManager.getLogger(ShapeFactory.class);

    public Shape createDefaultShape(ShapeType type, int n)
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
            case POLYGON:
            {
                shape= new MultiAngleShape(n);
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
        Scanner in = new Scanner(System.in);
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
            case POLYGON:
            {
                shape = new MultiAngleShape(points, points.length);
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
