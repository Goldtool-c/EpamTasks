package com.epam.jwd.service.impl;

import com.epam.jwd.app.Main;
import com.epam.jwd.exception.ShapeNotFoundException;
import com.epam.jwd.model.Shape;
import com.epam.jwd.model.ShapeType;
import com.epam.jwd.model.SimpleShapeFactory;
import com.epam.jwd.repository.ShapeStorage;
import com.epam.jwd.service.ShapeCrud;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class ShapeCrudImpl implements ShapeCrud {
    private static final Logger LOGGER = LogManager.getLogger(ShapeCrudImpl.class);
    @Override
    public Shape create(ShapeType type, int n) {
        return SimpleShapeFactory.GENERAL.createDefaultShape(type, n);
    }

    @Override
    public ArrayList<Shape> multiCreate(ShapeType type, int n, int vertex) {
        ArrayList<Shape> temp= new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            temp.add(SimpleShapeFactory.GENERAL.createDefaultShape(type, vertex));
        }
        return temp;
    }

    @Override
    public Shape delete() {
        return null;
    }

    @Override
    public Shape findId(int id) throws ShapeNotFoundException {
        Shape shape = null;
        for (int i = 0; i < ShapeStorage.GENERAL.getLength(); i++) {
            if(ShapeStorage.GENERAL.get(i).getId()==id)
            {
                shape=ShapeStorage.GENERAL.get(i);
                break;
            }
        }
        if(shape == null)
        {
            LOGGER.error("Shape with id: "+id+" is not found");
            throw new ShapeNotFoundException("Shape with id: "+id+" is not found");
        }
        return shape;
    }

    @Override
    public ArrayList<Shape> findAll()
    {
        return ShapeStorage.GENERAL.getAll();
    }
    @Override
    public Shape update() {
        return null;
    }
}
