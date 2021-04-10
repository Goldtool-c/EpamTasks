package com.epam.jwd.validator;

import com.epam.jwd.exception.InvalidShapeException;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.ShapeType;

public interface ShapePostProcessor {
    boolean valid(ShapeType type, Point[] points) throws InvalidShapeException;
}
