package com.epam.jwd.app;

import com.epam.jwd.exception.InvalidShapeException;
import com.epam.jwd.model.SimpleShapeFactory;
import com.epam.jwd.model.*;
import com.epam.jwd.repository.ShapeStorage;
import com.epam.jwd.validator.FigurePreProcessor;
import com.epam.jwd.validator.FigurePostProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args){
        LOGGER.info("Program started");
        ArrayList<Point> points= new ArrayList<>();
        ArrayList<Shape> lines = new ArrayList<>();
        ArrayList<Shape> triangles = new ArrayList<>();
        ArrayList<Shape> squares = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            lines.add(SimpleShapeFactory.GENERAL.createDefaultShape(ShapeType.LINE,0));
            triangles.add(SimpleShapeFactory.GENERAL.createDefaultShape(ShapeType.TRIANGLE,0));
        }
        for (int i = 0; i < 4; i++) {
            points.add(new Point());
        }
        squares.add(SimpleShapeFactory.GENERAL.createDefaultShape(ShapeType.SQUARE,0));
        System.out.println("Set number of polygon vertexes");
        Scanner in1 = new Scanner(System.in);
        int temp = in1.nextInt();
        SimpleShapeFactory.GENERAL.createDefaultShape(ShapeType.POLYGON, temp);
        int i=0;
        do {
            LOGGER.info(i+1+"st point:"+points.get(i));
            i++;
        }while (i<4);
        for (int j = 0; j < 2; j++)
        {
            try {
                FigurePreProcessor.GENERAL.pointsValid(ShapeType.LINE, lines.get(j).getPoints());
                FigurePostProcessor.GENERAL.valid(ShapeType.LINE, lines.get(j).getPoints());
                LOGGER.info(lines.get(j));
            } catch (InvalidShapeException e) {
             LOGGER.error("Shape "+j+1+" is not a line");
            }
        }
        for (int j = 0; j < 2; j++)
        {
            try {
                FigurePreProcessor.GENERAL.pointsValid(ShapeType.TRIANGLE, triangles.get(j).getPoints());
                FigurePostProcessor.GENERAL.valid(ShapeType.TRIANGLE, triangles.get(j).getPoints());
                LOGGER.info(triangles.get(j));
            } catch (InvalidShapeException e) {
                LOGGER.error("Shape "+j+1+" is not a triangle");
            }
        }
        try {
            FigurePreProcessor.GENERAL.pointsValid(ShapeType.TRIANGLE, squares.get(0).getPoints());
            FigurePostProcessor.GENERAL.valid(ShapeType.TRIANGLE, squares.get(0).getPoints());
            LOGGER.info(squares.get(0));
        } catch (InvalidShapeException e) {
            LOGGER.error("Shape "+1+" is not a square");
        }
    }
}
