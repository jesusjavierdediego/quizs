/*
CountDiv
Compute number of integers divisible by k in range [a..b].

Write a function:
int solution(int A, int B, int K);
that, given three integers A, B and K, returns the number of integers 
within the range [A..B] that are divisible by K, i.e.:
{ i : A ≤ i ≤ B, i mod K = 0 }
For example, for A = 6, B = 11 and K = 2, your function should return 3, 
because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
Assume that:
A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
 */

package com.me.quizs;

/**
 *
 * @author administrator
 */
public class CountDiv {
    public static void main(String[] args) {
        //int[] start = {6, 11, 2};
        System.out.println(solution(6, 11, 2));
    }

    public static int solution(int A, int B, int K) {
//        int result = 0;
//        for(int i = A;i<=B;i++){
//            if ( (i % K) == 0){
//                result++;
//            }
//        }
//        return result;
        return B / K - (A / K) + (A % K == 0 ? 1 : 0);
    }
}