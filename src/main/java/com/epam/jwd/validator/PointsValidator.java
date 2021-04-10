package com.epam.jwd.validator;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.ShapeType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PointsValidator implements ShapePreProcessor {
    private static final Logger LOGGER = LogManager.getLogger(PointsValidator.class);
    @Override
    public boolean pointsValid(ShapeType type, Point[] points)
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
                LOGGER.error("Invalid number of points");
                result = false;
                break;
        }
        return result;
    }
}
