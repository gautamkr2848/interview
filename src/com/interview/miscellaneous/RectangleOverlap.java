package com.interview.miscellaneous;

// l1
// --------------------

//                                    l2
//                                    ------------------


//                                    ------------------
//                                                        r2
// --------------------
//                    r1

class Point {
    int x, y;
}

public class RectangleOverlap {

    public Boolean rectangleOverlap(){
        Point l1 = new Point(),r1 = new Point(),
                l2 = new Point(),r2 = new Point();
        l1.x=-21;l1.y=26; r1.x=89;r1.y=4;
        l2.x=-17;l2.y=4; r2.x=41;r2.y=-73;

        // If one rectangle is on left side of other
        if (l1.x >= r2.x || l2.x >= r1.x) {
            return false;
        }

        // If one rectangle is above other
        if (l1.y <= r2.y || l2.y <= r1.y) {
            return false;
        }
        return true;
    }

}
