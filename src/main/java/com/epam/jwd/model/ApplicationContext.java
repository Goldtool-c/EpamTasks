package com.epam.jwd.model;

import com.epam.jwd.decorator.ShapeDecorator;
import com.epam.jwd.exception.InvalidShapeException;
import com.epam.jwd.validator.FigurePostProcessor;
import com.epam.jwd.validator.FigurePreProcessor;

public enum ApplicationContext {
    GENERAL;
    public Shape createShape(Point[] points, ShapeType type, int n) throws InvalidShapeException {
        Shape shape;
        FigurePreProcessor.GENERAL.pointsValid(type, points);
        shape = ShapeDecorator.GENERAL.createShape(type, points, n);
        FigurePostProcessor.GENERAL.valid(type, points);
        return shape;
    }
}
