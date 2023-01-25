package com.interview.string;

/*
Given a 2D grid of characters and a single word/an array of words, find all occurrences of the given word/words in the
grid. A word can be matched in all 8 directions at any point. Word is said to be found in a direction if all characters
match in this direction (not in zig-zag form).
The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up, Vertically Down and 4 Diagonal directions.
Example:

Input:  grid[][] = {"GEEKSFORGEEKS",
                    "GEEKSQUIZGEEK",
                    "IDEQAPRACTICE"};
        word = "GEEKS"

Output: pattern found at 0, 0
        pattern found at 0, 8
        pattern found at 1, 0
Explanation: 'GEEKS' can be found as prefix of
1st 2 rows and suffix of first row

Time complexity: O(R*C*8*len(str)).
All the cells will be visited and traversed in 8 directions, where R and C is side of matrix so time complexity is O(R*C).
Auxiliary Space: O(1).
 */

public class WordSearch {

    static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };
    static int R = 3;
    static int C = 13;

    public void wordSearch(){
        char[][] grid = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
                { 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
                { 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };

        String word = "GEEKS";
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == word.charAt(0)  && search2D(grid, i, j, word))
                    System.out.println("pattern found at " + i + ", " + j);
            }
        }
    }

    private Boolean search2D(char[][] grid, int i, int j, String word){
        int n = word.length();

        for (int dir = 0; dir < 8; dir++) {
            int k, rd = i + x[dir], cd = j + y[dir];

            for (k = 1; k < n; k++) {     // First character is already checked, match remaining characters

                Boolean isSafe = (rd >= 0) && (rd < R) && (cd >= 0) && (cd < C) && grid[rd][cd] == word.charAt(k);
                if(!isSafe)
                    break;

                rd += x[dir];       // Moving in particular direction
                cd += y[dir];
            }

            if (k == n)
                return true;
        }
        return false;
    }
}
