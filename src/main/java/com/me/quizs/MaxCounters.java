/*
You are given N counters, initially set to 0, and you have two possible operations on them:
increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty zero-indexed array A of M integers is given. This array represents consecutive operations:
if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:
    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:
    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.
Write a function:
class Solution { public int[] solution(int N, int[] A); }
that, given an integer N and a non-empty zero-indexed array A consisting of M integers, returns a sequence of integers representing the values of the counters.
The sequence should be returned as:
a structure Results (in C), or
a vector of integers (in C++), or
a record Results (in Pascal), or
an array of integers (in any other programming language).
For example, given:
    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.
Assume that:
N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
 */

package com.me.quizs;

import java.util.Arrays;

/**
 *
 * @author administrator
 */
public class MaxCounters {
    public static void main(String[] args) {
        int N = 5;
        int[] A = {3, 4, 4, 6, 1, 4, 4};

        int j=0;
        for (int d: solution(N, A)){
            System.out.println(d);
            j++;
        }
    }
    
    static int[] solution(int N, int[] A) {
        int arrSize = A.length;
        int currMax = 0;
        int[] count = new int[N];
        
        for(int i = 0; i < arrSize; i++){
            //if A[K] = X, such that 1 ≤ X ≤ N, then increase(X)
            if(A[i] <= N){//is 3 < 5?
                int pos = A[i] - 1;//pos = 2
                count[pos] += 1;//count[2] +=1
                if (count[pos] > currMax){ 
                    currMax = count[pos];
                }
            } else {
                Arrays.fill(count, currMax);
            }
        }
        
        return count;
    }
}
