/*
 Find the minimal average of any slice containing at least two elements.

 A non-empty zero-indexed array A consisting of N integers is given. 

 A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A 
 (notice that the slice contains at least two elements). 
 The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided 
 by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 For example, array A such that:
 A[0] = 4
 A[1] = 2
 A[2] = 2
 A[3] = 5
 A[4] = 1
 A[5] = 5
 A[6] = 8
 contains the following example slices:
 slice (1, 2), whose average is (2 + 2) / 2 = 2;
 slice (3, 4), whose average is (5 + 1) / 2 = 3;
 slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 The goal is to find the starting position of a slice whose average is minimal.
 Write a function:
 int solution(int A[], int N);
 that, given a non-empty zero-indexed array A consisting of N integers, 
 returns the starting position of the slice with the minimal average. 
 If there is more than one slice with a minimal average, 
 you should return the smallest starting position of such a slice.
 For example, given array A such that:
 A[0] = 4
 A[1] = 2
 A[2] = 2
 A[3] = 5
 A[4] = 1
 A[5] = 5
 A[6] = 8
 the function should return 1, as explained above.
 Assume that:
 N is an integer within the range [2..100,000];
 each element of array A is an integer within the range [−10,000..10,000].
 */
package com.me.quizs;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 *
 * @author administrator
 */
public class CountDiv {

    public static void main(String[] args) {
        int[] start = {4, 2, 2, 5, 1, 5, 8};
        System.out.println(solution(start));

        //System.out.println("The sum is " + IntStream.of(start).sum());
    }

    public static int solution(int[] A) {
        
        TreeMap<BigDecimal, List> slicesMap = new TreeMap<BigDecimal, List>();
        
        for (int i = 0; i < A.length; i++) {
            List sliceIndexes = new ArrayList();
            sliceIndexes.add(i);
            try {
                for (int j = i + 1; j < A.length; j++) {
                    sliceIndexes.add(j);
                    int[] slice = Arrays.copyOfRange(A, i, j + 1);

                    
                    BigDecimal sum = new BigDecimal(IntStream.of(slice).sum());
                    BigDecimal sliceLength = new BigDecimal(slice.length);
                    BigDecimal tempResult = sum.divide(sliceLength,2,RoundingMode.HALF_UP);
                    
                    slicesMap.put(tempResult, sliceIndexes);

                }
            } catch (ArrayIndexOutOfBoundsException e) {
                //Do nothing
            }

        }
        return (int)slicesMap.get(slicesMap.firstKey()).get(0);

    }
}
