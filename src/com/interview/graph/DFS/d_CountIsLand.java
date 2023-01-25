package com.interview.graph.DFS;

//0 1 0
//0 1 0
//0 0 0
//1 1 0
//1 0 1
//0 1 1
//1 1 1
//0 1 1
//1 0 1

/*
Initialize a boolean[][] matrix visited of the size of the given matrix to false.
Initialize count = 0, to store the answer.
Traverse a loop from 0 till ROW
    Traverse a nested loop from 0 to COL
        If the value of the current cell in the given matrix is 1 and is not visited
            Call DFS function
                Initialize rowNbr[] = { -1, -1, -1, 0, 0, 1, 1, 1 } and colNbr[] = { -1, 0, 1, -1, 1, -1, 0, 1 } for the neighbour cells.
                Mark the current cell as visited
                Run a loop from 0 till 8 to traverse the neighbor
                    If the neighbor is safe to visit and is not visited
                        Call DFS recursively on the neighbor.
            Increment count by 1
Return count as the final answer.
*/

public class d_CountIsLand {

    int ROW = 4, COL = 2;
    public void countIslands() {
        /*int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };*/

        int M[][] = {{0, 1},
                {1, 0},
                {1, 1},
                {1, 0}};
        System.out.println("Number of islands is: " + countIslands(M));
    }

    private int countIslands(int M[][]) {
        boolean visited[][] = new boolean[ROW][COL];
        int count = 0;

        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < COL; j++)
                if (M[i][j] == 1 && !visited[i][j]) {
                    DFS(M, i, j, visited);
                    count++;
                }
        return count;
    }

    private void DFS(int M[][], int row, int col, boolean visited[][]) {
        int rowNbr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int colNbr[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

        visited[row][col] = true;

        for (int k = 0; k < 8; k++) {
            Boolean isSafe = (row + rowNbr[k] >= 0) && (row + rowNbr[k] < ROW) && (col + colNbr[k] >= 0) && (col + colNbr[k] < COL) && M[row + rowNbr[k]][col + colNbr[k]] == 1 && !visited[row + rowNbr[k]][col + colNbr[k]];
            if (isSafe)
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
        }
    }

    public int numIslands() {

        int grid[][] = {{0, 1},
                {1, 0},
                {1, 1},
                {1, 0}};

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    dfsUtil(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfsUtil(int[][] M, boolean[][] visited, int row, int col){
        int rowNbr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int colNbr[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

        visited[row][col] = true;

        for (int k = 0; k < 8; k++) {
            Boolean isSafe = (row + rowNbr[k] >= 0) && (row + rowNbr[k] < ROW) && (col + colNbr[k] >= 0) && (col + colNbr[k] < COL) && M[row + rowNbr[k]][col + colNbr[k]] == 1 && !visited[row + rowNbr[k]][col + colNbr[k]];
            if (isSafe)
                dfsUtil(M, visited, row + rowNbr[k], col + colNbr[k]);
        }
    }
}
