package com.interview.graph.BFS;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RottingOranges {

    public static void timeToRottenOrange(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int[][] visited = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        int max = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++){
                if(mat[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }

        int[] xDir = {0, 1, 0, -1};
        int[] yDir = {1, 0, -1, 0};
        while (!q.isEmpty()) {
            Pair tmp = q.poll();
            visited[tmp.row][tmp.col] = 1;
            max = Math.max(max, tmp.time);
            for(int i=0; i<4; i++) {
                if(tmp.row + xDir[i] < m && tmp.row + xDir[i] >=0 && tmp.col + yDir[i] >=0 && tmp.col + yDir[i] < n && mat[tmp.row + xDir[i]][tmp.col + yDir[i]] == 1 && mat[tmp.row + xDir[i]][tmp.col + yDir[i]] != 2 && visited[tmp.row + xDir[i]][tmp.col + yDir[i]] != 1) {
                    q.add(new Pair(tmp.row + xDir[i], tmp.col + yDir[i], tmp.time + 1));
                }
            }
        }

        System.out.println(max);
    }

    public static void main(String[] args) {
        int v[][] = { { 2, 1, 0, 2, 1 },
                { 1, 0, 1, 2, 1 },
                { 1, 0, 0, 2, 1 } };
        timeToRottenOrange(v);
    }
}

class Pair{
    int row;
    int col;
    int time;

    public Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
