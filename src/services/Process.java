package services;

import interfaces.Activity;

import java.util.HashSet;
import java.util.Set;

public class Process {

    private Activity activity;
    private Set<int[]> visited = new HashSet<>();

    public void moveBack() {
        activity.turnRight();
        activity.turnRight();
        activity.move();
        activity.turnRight();
        activity.turnRight();
    }

    public void backtracking(int x, int y, int direction) {
        visited.add(new int[]{x, y});
        activity.cleanTheSpot();

        int newX = x;
        int newY = y;


        for (int i = 0; i < 4; i++) {
            int newDirection = (direction + i) % 4;
            if (newDirection == 0) {
                newX -= 1;
            } else if (newDirection == 1){
                newY += 1;
            } else if (newDirection == 2) {
                newX += 1;
            } else if (newDirection == 3) {
                newY -= 1;
            }

            if (!visited.contains(new int[]{newX, newY}) && activity.move()) {
                backtracking(newX,newY,newDirection);
                moveBack();
            }
            activity.turnRight();
        }
    }


    public void cleanTheRoom(Activity activity) {
        this.activity = activity;
        backtracking(0,0,0);
    }
}
