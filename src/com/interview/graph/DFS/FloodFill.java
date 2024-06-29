package com.interview.graph.DFS;

public class FloodFill {

    public static int[][] floodFill(int[][] mat, int sr, int sc, int newColor) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m+1][n+1];
        int[][] ans = mat;

        dfsUtil(mat, ans, visited, sr, sc, newColor, mat[sr][sc]);
        return ans;
    }

    public static void dfsUtil(int[][] mat, int[][] ans, boolean[][] visited, int sr, int sc, int newColor, int oldColor){
        visited[sr][sc] = true;

        ans[sr][sc] = newColor;

        int[] xDir = {0, 1, 0, -1};
        int[] yDir = {1, 0, -1, 0};

        for(int k=0; k<4; k++) {
            int tmp2 = sc + yDir[k];
            int tmp1 = sr + xDir[k];

            boolean isSafe =  tmp2 >=0 && tmp2 < mat[0].length && tmp1 >=0 && tmp1 < mat.length && !visited[tmp1][tmp2] && mat[tmp1][tmp2] == oldColor && mat[tmp1][tmp2] != newColor;
            if(isSafe) {
                dfsUtil(mat, ans, visited, tmp1, tmp2, newColor, oldColor);
            }
        }
    }

    public static void main(String[] args){
        int[][] screen ={
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1}};

        floodFill(screen, 7, 6, 3);
    }
 }
