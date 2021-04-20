package com.epam.jwd.service;

import com.epam.jwd.exception.ShapeNotFoundException;
import com.epam.jwd.model.Shape;
import com.epam.jwd.model.ShapeType;

import java.util.ArrayList;

public interface ShapeCrud {
    Shape create(ShapeType type, int n);
    ArrayList<Shape> multiCreate(ShapeType type, int n, int vertex);
    Shape delete();
    Shape findId(int id) throws ShapeNotFoundException;
    ArrayList<Shape> findAll();
    Shape update();
}
