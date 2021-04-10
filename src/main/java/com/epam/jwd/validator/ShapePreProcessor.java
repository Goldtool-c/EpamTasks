package com.epam.jwd.validator;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.ShapeType;

public interface ShapePreProcessor {
    boolean pointsValid(ShapeType type, Point[] points);
}
