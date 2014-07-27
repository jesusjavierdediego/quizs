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
        int[] start = {1, 2, -3, 4, 5, -6};
        System.out.println(solution(start));
    }

//    public static int solution(int[] S) {
//      int max_sum = 0;
//      int current_sum = 0;
//      boolean positive = false;
//      int n = S.length;
//      for (int i = 0; i < n; ++i) {
//          int item = S[i];
//          System.out.println("item: " + item);
//         if (item < 0) {
//                if (max_sum < current_sum) {
//                    max_sum = current_sum;
//                    current_sum = 0;
//                }
//          } else {
//                positive = true;
//                System.out.println("item positive: " + item);
//                System.out.println("current_sum1: " + current_sum);
//                
//                current_sum += item;
//                
//                System.out.println("current_sum2: " + current_sum);
//          }
//      }
//      System.out.println("current_sum: " + current_sum);
//      System.out.println("max_sum: " + max_sum);
//      if (current_sum > max_sum) {
//          max_sum = current_sum;
//      }
//      if (positive) {
//          return max_sum;
//      }
//
//      return -1;
//    }
    public static int solution(int[] A) {
        int max_sum = 0;
        int current_sum = 0;

        for (int i = 0; i < A.length; ++i) {
            try {
                if (A[i] > 0) {
                    current_sum = A[i];
                }
                if (A[i + 1] > 0) {
                    current_sum = A[i] + A[i + 1];
                }
                if (current_sum > max_sum) {
                    max_sum = current_sum;
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }

        }

      //System.out.println("max_sum: " + max_sum);
        return max_sum;
    }

}
