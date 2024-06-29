package com.interview.miscellaneous;

/*Input :15
  Output :3
  15 can be represented as:
  1+2+3+4+5
  4+5+6
  7+8*/

public class  SumOfConsecutives {

    public void sumOfConsecutives(){
        int n = 15;
        int count = 0;
        for (int i = 1; (i * (i + 1))/2 <  n; i++){
            float a = (float) ((1.0 * n-(i * (i + 1)) / 2) / (i + 1));
            if (a-(int)a == 0.0)
                count++;
        }
        System.out.println(count);
    }

}
