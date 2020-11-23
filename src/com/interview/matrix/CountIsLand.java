package com.interview.matrix;

public class CountIsLand {

    public void countIsLand(){
        int[][] mat =  {{0, 0, 0},
                        {1, 1, 0},
                        {1, 1, 0},
                        {0, 0, 1}};
        int count = 0, m = 4, n = 3;

        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                if(mat[i][j] == 1){
                    if((i == 0 || mat[i-1][j] == 0) &&
                            (j == 0 || mat[i][j-1] == 0))
                        count++;
                }
            }
        }
        System.out.println(count);
    }
}
