package com.me.quizs;

/*
A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.
Count the minimal number of jumps that the small frog must perform to reach its target.
Write a function:
class Solution { public int solution(int X, int Y, int D); }
that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
For example, given:
  X = 10
  Y = 85
  D = 30
the function should return 3, because the frog will be positioned as follows:
after the first jump, at position 10 + 30 = 40
after the second jump, at position 10 + 30 + 30 = 70
after the third jump, at position 10 + 30 + 30 + 30 = 100
Assume that:
X, Y and D are integers within the range [1..1,000,000,000];
X ≤ Y.
 */



/**
 *
 * @author administrator
 */
public class SmallFrog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] start = {};
        //solution(10,85,30);
        System.out.println(solution(10,85,30));
    }
    
    public static int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        
        double diff = Y - X;
        double jumps = diff/D;
        int result = 0;
        if((jumps-(int)jumps)!=0){
            result = (int)jumps + 1;
        }

        System.out.println(result);
        
        return 0;
    }
    
}
