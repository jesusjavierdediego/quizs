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
/*
 The key to solve this task is these two patterns:  
 (1) There must be some slices, with length of two or three, having the minimal average value among all the slices. 
 (2) And all the longer slices with minimal average are built up with these 2-element and/or 3-element small slices.
Firstly we will prove the statement (1). In all the following discussion, 
we assume the slices have two or more element. In every array, there must be at lease one slice, 
to say S, having the Minimal Average (MA). And PLEASE PAY ATTENTION, the following proof is done with the S, 
which HAS the global minimal average.

If the length of S is two or three, it follows our conclusion.

If the length of S is odd, we could divide it into a 3-element sub-slice and some 2-element sub-slice. 

For example, for the slice [1, 2, 3, 4, 5], we could get a 3-element sub-slice [1, 2, 3] and a 2-element 
sub-slice [4, 5]. Or differently we could get [1, 2] and [3, 4, 5]. But the split does not matter in the following prove.
If the sub-slices have different averages, some of them will have smaller average than MA. But it conflicts with the 
condition that, the MA is known as the global minimal average for all slices.  By this contradictory, it’s proved that 
all the sub-slices MUST have the same average.
If all the sub-slices have the same average, the average of them must be MA. So all these sub-slices have overall minimal 
average and length of two or three.
If the length of S is even, we could divide it into some 2-element sub-slice. For the slice [1, 2, 3, 4], 
the only possible split is [1, 2] and [3, 4]. Then, similar with the previous case, all these 2-element sub-slices 
have the global minimal average.
And in the construction in step b, we have already proven the statement (2).

UPDATE 03-13-2014: We are NOT proving that, 4-or-more-element slices cannot have the global minimal average. We just proved that, there MUST be some 2-element and/or 3-element slices, having the global minimal average. In other words, we are NOT SURE whether there are some 4-or-more-element slices holding global minimal average. But we are ONE HUNDRED PERCENT SURE about the 2-element and/or 3-element slices.
 */
package com.me.quizs;

//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import java.util.List;
//import java.util.TreeMap;
//import java.util.stream.IntStream;

/**
 *
 * @author administrator
 */
public class MinAvgTwoSlice {

    public static void main(String[] args) {
        int[] start = {4, 2, 2, 5, 1, 5, 8};
        System.out.println(solution(start));

        //System.out.println("The sum is " + IntStream.of(start).sum());
    }

    public static int solution(int[] A) {

//        TreeMap<BigDecimal, List> slicesMap = new TreeMap<BigDecimal, List>();
//        
//        for (int i = 0; i < A.length; i++) {
//            List sliceIndexes = new ArrayList();
//            sliceIndexes.add(i);
//            try {
//                for (int j = i + 1; j < A.length; j++) {
//                    sliceIndexes.add(j);
//                    int[] slice = Arrays.copyOfRange(A, i, j + 1);
//
//                    
//                    BigDecimal sum = new BigDecimal(IntStream.of(slice).sum());
//                    BigDecimal sliceLength = new BigDecimal(slice.length);
//                    BigDecimal tempResult = sum.divide(sliceLength,2,RoundingMode.HALF_UP);
//                    
//                    slicesMap.put(tempResult, sliceIndexes);
//
//                }
//            } catch (ArrayIndexOutOfBoundsException e) {
//                //Do nothing
//            }
//
//        }
//        return (int)slicesMap.get(slicesMap.firstKey()).get(0);
        
        
        double minAvg = 100000;//a large number for reference
        int index = 0;

        if (A.length <= 2) {

            return 0;
        }
        /*
        There must be some slices, with length of two or three, 
        having the minimal average value among all the slices. 
        */
        for (int i = 0; i < A.length - 2; i++) {

            if ((A[i] + A[i + 1]) / 2.0 < minAvg) {
                minAvg = (A[i] + A[i + 1]) / 2.0;
                index = i;
            }

            if ((A[i] + A[i + 1] + A[i + 2]) / 3.0 < minAvg) {

                minAvg = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
                index = i;
            }
        }
        
        /*
        And all the longer slices with minimal average are built up 
        with these 2-element and/or 3-element small slices. 
        */
        int aMax = A.length - 2;

        if ((A[aMax] + A[aMax + 1]) / 2.0 < minAvg) {

            minAvg = (A[aMax] + A[aMax + 1]) / 2.0;
            index = aMax;
        }

        return index;
    }
}

