package com.epam.jwd.validator;

import com.epam.jwd.exception.InvalidShapeException;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.ShapeType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum  FigurePreProcessor implements  ShapePreProcessor {
    GENERAL;
   // private static final Logger LOGGER = LogManager.getLogger(PointsValidator.class);
    public boolean pointsValid(ShapeType type, Point[] points) throws InvalidShapeException
    {
        boolean result = false;
        switch (type)
        {
            case LINE:
                if(points.length==2)
                    result=true;
                break;
            case SQUARE:
                if(points.length==4)
                    result=true;
                break;
            case TRIANGLE:
            if(points.length==3)
                result=true;
            break;
            default:
     //           LOGGER.error("Invalid number of points");
                throw new InvalidShapeException("Invalid number of points");
        }
        return result;
    }
}
