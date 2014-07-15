package com.me.quizs;

/*
 A zero-indexed array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 Your goal is to find that missing element.
 Write a function:
 class Solution { public int solution(int[] A); }
 that, given a zero-indexed array A, returns the value of the missing element.
 For example, given array A such that:
 A[0] = 2
 A[1] = 3
 A[2] = 1
 A[3] = 5
 the function should return 4, as it is the missing element.
 Assume that:
 N is an integer within the range [0..100,000];
 the elements of A are all distinct;
 each element of array A is an integer within the range [1..(N + 1)].
 */


/**
 *
 * @author administrator
 */
public class PermMissingElem {

    public static void main(String[] args) {
        int[] start = {2, 3, 1, 5};
        System.out.println(solution(start));
    }

//    static int solution(int A[]) {
//        long initial = A[0];
//
//        for (int i = 1; i < A.length; i++) {
//            initial++;
//            if (initial != A[i]) {
//                break;
//            }
//        }
//
//        return (int) initial;
//    }

    static int solution(int[] data) {

        long N = data.length + 1;
        long total = (N * (N + 1)) / 2;
        

        long sum = 0L;

        for (int i : data) {

            sum += i;
        }
        
        System.out.println(total);
        System.out.println(sum);

        return (int) (total - sum);
    }

}
