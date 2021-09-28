package com.interview.stack;

import java.util.Stack;

public class MaxRectangleArea {

    public int maxRectangle(int A[][]) {

        int result = maxHist(A[0]);

        for (int i = 1; i < 4; i++) {

            for (int j = 0; j < 4; j++)
                if (A[i][j] == 1)
                    A[i][j] = A[i][j] + A[i - 1][j];

            result = Math.max(result, maxHist(A[i]));
        }

        return result;
    }

    static int maxHist(int row[]) {

        Stack<Integer> result = new Stack<>();
        int top_val;
        int max_area = 0;
        int area = 0;

        int i = 0;
        while (i < row.length) {
            if (result.empty() || row[result.peek()] <= row[i])
                result.push(i++);
            else {
                top_val = row[result.peek()];
                result.pop();
                area = top_val * i;

                if (!result.empty())
                    area = top_val * (i - result.peek() - 1);
                max_area = Math.max(area, max_area);
            }
        }

        while (!result.empty()) {
            top_val = row[result.peek()];
            result.pop();
            area = top_val * i;
            if (!result.empty())
                area = top_val * (i - result.peek() - 1);

            max_area = Math.max(area, max_area);
        }
        return max_area;
    }
}
