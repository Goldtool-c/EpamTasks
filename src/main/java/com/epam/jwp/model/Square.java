package com.epam.jwp.model;

import java.util.Scanner;

public class Square extends Shape {

    public Square(Point []points1) {
        n=4;
        points = new Point[n];
        for (int i = 0; i < n ; i++) {
            points[i]=points1[1];
        }
    }
    public Square()
    {
        n=4;
        points = new Point[n];
        points[0]=new Point(0,0);
        points[1]= new Point(0,2);
        points[2]=new Point(2,2);
        points[3]= new Point(2, 0);
    }
    public Square(int a)
    {
        n=4;
        int x,y;
        for (int i = 0; i < n ; i++) {
            Scanner in = new Scanner(System.in);
            x = in.nextInt();
            y = in.nextInt();
            this.setPoint(i, x, y);
        }
    }
    @Override
    public boolean isThisShape() {
        boolean isSquare = false;
        boolean[] squares = new boolean[4];
        n=4;
        int counterX = 0;
        int counterY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(points[i].getX()==points[j].getX())
                {
                    counterX++;
                }
                if(points[i].getY()==points[j].getY())
                {
                    counterY++;
                }
            }
            if(counterX==2&&counterY==2)
            {
                counterX=0;
                counterY=0;
                squares[i]=true;
            }
        }
        counterX=0;
        for (int i = 0; i < n; i++) {
            if(squares[i])
            {
                counterX++;
            } else {break;}
        }
        if(counterX==4)
        {
            isSquare=true;
        }
        return isSquare;
    }
}
