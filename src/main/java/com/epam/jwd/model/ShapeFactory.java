package com.epam.jwd.model;

public interface ShapeFactory {

    Shape createShape(ShapeType type, Point[] points, int n);
}
