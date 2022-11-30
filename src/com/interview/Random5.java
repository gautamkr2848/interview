package com.interview;

public class Random5 {

    public void random7() {
        // you can use random5() for generating 0 - 4 with equal probability.
        //int random25 = 5 * random5() + random5();
        //while (random25 > 20) {
        //    random25 = 5 * random5() + random5();
        //}
        //return random25 % 7;
    }

    public void random7_2() {
        // you can use random2()
        //int random7 = rand2() + rand2() * 2 + rand2() * 4;
        //while (random7 == 7) {
        //    random7 = rand2() + rand2() * 2 + rand2() * 4;
        //}
        //return random7;
    }

/*
random10_using_random7

ref - https://leetcode.com/problems/implement-rand10-using-rand7/solution/

This solution is based upon Rejection Sampling. The main idea is when you generate a number in the desired range,
output that number immediately. If the number is out of the desired range, reject it and re-sample again. As each number
in the desired range has the same probability of being chosen, a uniform distribution is produced.

Obviously, we have to run rand7() function at least twice, as there are not enough numbers in the range of 1 to 10. By
running rand7() twice, we can get integers from 1 to 49 uniformly. Why?

image - https://leetcode.com/problems/implement-rand10-using-rand7/Figures/470/rejectionSamplingTable.png

A table is used to illustrate the concept of rejection sampling. Calling rand7() twice will get us row and column index
that corresponds to a unique position in the table above. Imagine that you are choosing a number randomly from the table
above. If you hit a number, you return that number immediately. If you hit a * , you repeat the process again until you
hit a number.

Since 49 is not a multiple of 10, we have to use rejection sampling. Our desired range is integers from 1 to 40, which
we can return the answer immediately. If not (the integer falls between 41 to 49), we reject it and repeat the whole
process again.
*/

    public void random10_using_random7() {
        //rand7() that generates a uniform random integer in the range [1, 7]
        //int row, col, idx;
        //do {
        //    row = rand7();
        //    col = rand7();
        //    idx = col + (row - 1) * 7;
        //} while (idx > 40);
        //return 1 + (idx - 1) % 10;
    }
}
