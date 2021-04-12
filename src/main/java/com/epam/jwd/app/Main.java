package com.epam.jwd.app;

import com.epam.jwd.exception.InvalidShapeException;
import com.epam.jwd.model.ShapeFactory;
import com.epam.jwd.model.*;
import com.epam.jwd.validator.FigurePreProcessor;
import com.epam.jwd.validator.FigurePostProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args){
        LOGGER.info("Program started");
        Point[] points=new Point[4];
        Shape[] lines = new Line[2];
        Shape[] triangles = new Triangle[2];
        Shape[] squares = new Square[1];
        int way;
        System.out.println("1 -- default\nOther -- set cords");
        Scanner in = new Scanner(System.in);
        way = in.nextInt();
        Point[] points1=new Point[2];
        Point[] points2=new Point[3];
        Point[] points3=new Point[4];
        switch (way)
        {
            case 1:
            {
                for (int i = 0; i < 2; i++) {
                    lines[i] = ShapeFactory.GENERAL.createDefaultShape(ShapeType.LINE,0);
                    triangles[i] = ShapeFactory.GENERAL.createDefaultShape(ShapeType.TRIANGLE,0);
                }
                for (int i = 0; i < 4; i++) {
                    points[i]=new Point();
                }
                squares[0]=ShapeFactory.GENERAL.createDefaultShape(ShapeType.SQUARE,0);
                break;
            }
            default:
            {
                for (int i = 0; i < 2; i++) {
                    System.out.println("Set "+(i+1)+"st line cords");
                    for (int j = 0; j < 2; j++) {
                        Scanner in1 = new Scanner(System.in);
                        points1[j].setX(in1.nextDouble());
                        points1[j].setY(in1.nextDouble());
                    }
                    lines[i] = ShapeFactory.GENERAL.createShape(ShapeType.LINE, points1);
                    System.out.println("Set "+(i+1)+"st triangle cords");
                    for (int j = 0; j < 3; j++) {
                        Scanner in1 = new Scanner(System.in);
                        points2[j].setX(in1.nextDouble());
                        points2[j].setY(in1.nextDouble());
                    }
                    triangles[i] = ShapeFactory.GENERAL.createShape(ShapeType.TRIANGLE, points2);
                }
                System.out.println("Set square cords");
                for (int j = 0; j < 4; j++) {
                    Scanner in1 = new Scanner(System.in);
                    points3[j].setX(in1.nextDouble());
                    points3[j].setY(in1.nextDouble());
                }
                for (int i = 0; i < 4; i++) {
                    System.out.println("Set number of polygon vertexes");
                    Scanner in1 = new Scanner(System.in);
                    int temp = in1.nextInt();
                    ShapeFactory.GENERAL.createDefaultShape(ShapeType.POLYGON, temp);
                }
                squares[0]= ShapeFactory.GENERAL.createShape(ShapeType.SQUARE, points3);
                break;
            }

        }
        int i=0;
        do {
            LOGGER.info(i+1+"st point:"+points[i]);
            i++;
        }while (i<4);
        for (int j = 0; j < 2; j++)
        {
            try {
                FigurePreProcessor.GENERAL.pointsValid(ShapeType.LINE, lines[j].getPoints());
                FigurePostProcessor.GENERAL.valid(ShapeType.LINE, lines[j].getPoints());
                LOGGER.info(lines[j]);
            } catch (InvalidShapeException e) {
             LOGGER.error("Shape "+j+1+" is not a line");
            }
        }
        for (int j = 0; j < 2; j++)
        {
            try {
                FigurePreProcessor.GENERAL.pointsValid(ShapeType.TRIANGLE, triangles[j].getPoints());
                FigurePostProcessor.GENERAL.valid(ShapeType.TRIANGLE, triangles[j].getPoints());
                LOGGER.info(triangles[j]);
            } catch (InvalidShapeException e) {
                LOGGER.error("Shape "+j+1+" is not a triangle");
            }
        }
        try {
            FigurePreProcessor.GENERAL.pointsValid(ShapeType.TRIANGLE, squares[0].getPoints());
            FigurePostProcessor.GENERAL.valid(ShapeType.TRIANGLE, squares[0].getPoints());
            LOGGER.info(squares[0]);
        } catch (InvalidShapeException e) {
            LOGGER.error("Shape "+1+" is not a square");
        }
    }
}
