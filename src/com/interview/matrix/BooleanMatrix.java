package com.interview.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Cell{
    int x,y;

    Cell(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BooleanMatrix {

    public void booleanMatrix(){
        int mat[][] = { {1, 0, 0, 1},
                        {0, 0, 1, 0},
                        {0, 0, 0, 0}};

        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        int m = mat.length;
        int n = mat[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(Integer i : row){
            for(int j=0; j<n; j++){
                mat[i][j] = 1;
            }
        }

        for(int i=0; i<m; i++){
            for(Integer j : col){
                mat[i][j] = 1;
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.println(mat[i][j]);
            }
        }
    }
}
