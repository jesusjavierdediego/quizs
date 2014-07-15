package com.me.quizs;

/*
 A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.
 Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 For example, consider array A such that:
 A[0] = 3
 A[1] = 1
 A[2] = 2
 A[3] = 4
 A[4] = 3
 We can split this tape in four places:
 P = 1, difference = |3 − 10| = 7 
 P = 2, difference = |4 − 9| = 5 
 P = 3, difference = |6 − 7| = 1 
 P = 4, difference = |10 − 3| = 7 
 Write a function:
 int solution(int A[], int N);
 that, given a non-empty zero-indexed array A of N integers, returns the minimal difference that can be achieved.
 For example, given:
 A[0] = 3
 A[1] = 1
 A[2] = 2
 A[3] = 4
 A[4] = 3
 the function should return 1, as explained above.
 Assume that:
 N is an integer within the range [2..100,000];
 each element of array A is an integer within the range [−1,000..1,000].
 */



/**
 *
 * @author administrator
 */
public class MinimalDifference {

    public static void main(String[] args) {
        int[] start = {3, 1, 2, 4, 3};
        solution(start);
    }

    static void solution(int A[]) {
        // write your code in C90
        int diff = 0;
        int N = A.length;
        int[] differences = new int[N - 1];
        for (int i = 1; i < N; i++) {

            //left sum
            int leftsum = 0;
            for (int j = 0; j < i; j++) {
                leftsum += A[j];
            }

            //right sum
            int rightsum = 0;
            int sup = i;
            while (sup < N) {
                rightsum += A[sup];
                sup++;
            }

            diff = leftsum - rightsum;
            if (diff < 0){
                diff = diff * (-1);
            }
            differences[i - 1] = diff;
            System.out.println("diff" + diff);
           //System.out.println(differences.length);

        }

        int smallest = differences[0];
        for (int i = 1; i < differences.length; i++) {
            if (differences[i] < smallest) {
                smallest = differences[i];
            }

        }
        System.out.println("smallest: " + smallest);

        //return 0;
    }

}
