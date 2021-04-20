package com.epam.jwd.repository;

import com.epam.jwd.model.Shape;

import java.util.ArrayList;

public enum ShapeStorage {
    GENERAL;
    private static ArrayList<Shape> array = new ArrayList<>();
    private static int length = array.size();
    public Shape get(int id){ return array.get(id); }
    public int getLength(){ return length;}
    public void add(Shape shape){ array.add(shape); length++; }
    public ArrayList<Shape> getAll(){ return array; }
}
