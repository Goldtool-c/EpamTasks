package com.epam.jwd.app;

import com.epam.jwd.exceptions.ShapeDoesNotExistException;
import com.epam.jwd.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) throws ShapeDoesNotExistException {
        LOGGER.info("Program started");
        Point[] points=new Point[4];
        Shape[] lines = new Line[2];
        Shape[] triangles = new Triangle[2];
        Shape[] squares = new Square[1];
        int way;
        System.out.println("1 -- default\nOther -- set cords");
        Scanner in = new Scanner(System.in);
        way = in.nextInt();
        switch (way)
        {
            case 1:
            {
                for (int i = 0; i < 2; i++) {
                    lines[i] = ShapeFactory.createShape(ShapeType.LINE);
                    triangles[i] = ShapeFactory.createShape(ShapeType.TRIANGLE);
                }
                for (int i = 0; i < 4; i++) {
                    points[i]=new Point();
                }
                squares[0]=ShapeFactory.createShape(ShapeType.SQUARE);
                break;
            }
            default:
            {
                for (int i = 0; i < 2; i++) {
                    System.out.println("Set "+(i+1)+"st line cords");
                    lines[i] = new Line(1);
                    System.out.println("Set "+(i+1)+"st triangle cords");
                    triangles[i] = new Triangle(1);
                }
                System.out.println("Set square cords");
                squares[0]= new Square(1);
                break;
            }

        }
        int i=0;
        do {
            LOGGER.info(i+1+"st point:"+points[i]);
            i++;
        }while (i<4);
        Shape.printShape(lines);
        Shape.printShape(triangles);
        Shape.printShape(squares);
    }
}
