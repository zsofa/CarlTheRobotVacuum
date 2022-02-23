package services;

import interfaces.Activities;

import java.util.HashSet;
import java.util.Set;

public class Cleaning implements Activities {


    private Set<int[]> visited = new HashSet<>();



    public void findTheWay(int currX, int currY, int currDirection) {

        visited.add(new int[]{currX, currY});
        cleanTheSpot();

        int newX = currX;
        int newY = currY;


        for (int i = 0; i < 4; i++) {
            int newDirection = (currDirection + i) % 4;
            switch(newDirection) {
                case 0:
                    newX -= 1;
                    break;
                case 1:
                    newY += 1;
                case 2:
                    newX += 1;
                case 3:
                    newY -= 1;
            }

            if (!visited.contains(new int[]{newX, newY}) && move()) {
                findTheWay(newX,newY,newDirection);
                moveBack();
            }
            turnRight();
        }
    }

    public void moveBack() {
        turnRight();
        turnRight();
        move();
        turnRight();
        turnRight();
    }

    public void run() throws Exception{
        try {
            findTheWay(0,0,0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Carl has a problem");
        }

    }

    @Override
    public void turnRight() {

    }

    @Override
    public void cleanTheSpot() {

    }

    @Override
    public boolean move() {
        return false;
    }

}
