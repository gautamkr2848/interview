package com.interview.matrix;

public class Island {

    public int numIslands(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Boolean[][] visited = new Boolean[m][n];
        int count = 0;

        for(int i=0; i<m ;i++){
            for(int j=0; j<n; j++){

                if(grid[i][j] == 1 && !visited[i][j]){
                    DFS(grid, i, j, visited, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    private void DFS(int[][] grid, int i, int j, Boolean[][] visited, int m, int n){

        int[] row = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] col = {-1, 0, 1, -1, 1, -1, 0, 1};

        visited[i][j] = Boolean.TRUE;

        for(int k=0; k<8; k++){
            Boolean tmp = ((i + row[k] >= 0) && (j + col[k] >= 0) && (i + row[k] < m) && (j + col[k] < n));

            if(tmp)
                DFS(grid, i + row[k], j + col[k], visited, m, n);
        }
    }
}
