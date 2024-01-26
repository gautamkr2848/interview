package com.interview.matrix;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return -1;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2)
                    rotAdjacent(grid, i, j, 2);
            }
        }

        int minutes = 2;
        for(int[] row : grid) {
            for(int cell : row) {
                if(cell == 1) return -1;
                minutes = Math.max(minutes, cell);
            }
        }

        return minutes - 2;
    }

    private void rotAdjacent(int[][] grid, int row, int col, int minutes) {
        if(row < 0 || row >= grid.length /* out of bounds */
                || col < 0 || col >= grid[0].length /* out of bounds */
                || grid[row][col] == 0 /* empty cell */
                || (1 < grid[row][col] && grid[row][col] < minutes) /* this orange is already rotten by another rotten orange */
        ) return;
        else {
            grid[row][col] = minutes;
            rotAdjacent(grid, row - 1, col, minutes + 1);
            rotAdjacent(grid, row + 1, col, minutes + 1);
            rotAdjacent(grid, row, col - 1, minutes + 1);
            rotAdjacent(grid, row, col + 1, minutes + 1);
        }
    }
}
