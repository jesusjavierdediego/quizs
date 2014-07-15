package com.me.quizs;

/*
A non-empty zero-indexed array A consisting of N integers is given.
A permutation is a sequence containing each element from 1 to N once, and only once.
For example, array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation.
The goal is to check whether array A is a permutation.
Write a function:
class Solution { public int solution(int[] A); }
that, given a zero-indexed array A, returns 1 if array A is a permutation and 0 if it is not.
For example, given array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.
Given array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.
Assume that:
N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
 */



import java.util.Arrays;

/**
 *
 * @author administrator
 */
public class PermCheck {
    public static void main(String[] args) {
        int[] start = {100,99,101,98};
        System.out.println(solution(start));
    }
    
//    static int solution(int[] A) {
//        // write your code in Java SE 8
//        //Arrays.sort(A);
//        
//        long N = A.length;
//        long total = (N * (N + 1)) / 2;
//        long sum = 0L;
//        
//        
//        
//        for(int v: A){
//            sum += v;
//        }
//        
//        System.out.println(total);
//        System.out.println(sum);
//        
//        if(total == sum)
//            return 1;
//        else
//            return 0;
//
//    }
    
    static int solution(int[] A) {
        Arrays.sort(A);
        int initial = A[0];
 
        for(int i= 1; i< A.length; i++){
            initial++;
            if(initial != A[i])
                return 0;
        }
        return 1;

    }
}
