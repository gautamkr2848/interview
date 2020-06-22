package com.interview.miscellaneous;

class Point {
    int x, y;
}

public class RectangleOverlap {

    public void rectangleOverlap(){
        Point l1 = new Point(),r1 = new Point(),
                l2 = new Point(),r2 = new Point();
        l1.x=0;l1.y=10; r1.x=10;r1.y=0;
        l2.x=5;l2.y=5; r2.x=15;r2.y=0;

        if (l1.x >= r2.x || l2.x >= r1.x) {
            System.out.println(false);
        }

        // If one rectangle is above other
        if (l1.y <= r2.y || l2.y <= r1.y) {
            System.out.println(false);
        }
        System.out.println(true);
    }

}
