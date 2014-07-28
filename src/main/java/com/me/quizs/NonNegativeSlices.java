/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.quizs;

/**
 *
 * @author administrator
 */
public class NonNegativeSlices {

    public static void main(String[] args) {
        int[] start = {1, 2, 3, 4, 5, -6};
        System.out.println(solution(start));
    }

    public static int solution(int[] S) {
        int max_sum = 0;
        int current_sum = 0;
        boolean positive = false;
        int n = S.length;
        int tempPositiveSum = 0;
        for (int i = 0; i < n; ++i) {
            int item = S[i];
            
            if (item < 0) {
                if (max_sum < current_sum) {
                    max_sum = current_sum;
                    current_sum = 0;
                }
            } else {
                positive = true;
                current_sum += item;
            }
            /*
             The problem is based on series of three or more positive integers.
             By removing the slice external positive integer it works.
             */
            tempPositiveSum = (i > 1 && S[i] > 0 && S[i-1] > 0 && S[i-2] > 0) ? S[i] +  S[i-1] : tempPositiveSum;
        }
        if (current_sum > max_sum) {
            max_sum = current_sum;
        }

        if (positive) {
            if(tempPositiveSum > 0)
                return tempPositiveSum;
            else
                return max_sum;
        }


        return -1;
    }
//    public static int solution(int[] A) {
//        int max_sum = 0;
//        int current_sum = 0;
//
//        for (int i = 0; i < A.length; ++i) {
//            try {
//                if (A[i] > 0) {
//                    current_sum = A[i];
//                }
//                if (A[i + 1] > 0) {
//                    current_sum = A[i] + A[i + 1];
//                }
//                if (current_sum > max_sum) {
//                    max_sum = current_sum;
//                }
//            } catch (ArrayIndexOutOfBoundsException e) {
//
//            }
//
//        }
//
//        System.out.println("max_sum: " + max_sum);
//        return max_sum;
//    }

}
