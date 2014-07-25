/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.quizs;

/*
 Write a function:
 class Solution { public int solution(int[] A); }
 that, given a non-empty zero-indexed array A of N integers, 
 returns the minimal positive integer that does not occur in A.
 For example, given:
 A[0] = 1    
 A[1] = 3    
 A[2] = 6
 A[3] = 4    
 A[4] = 1    
 A[5] = 2
 the function should return 5.

 */
public class MissingInteger {

    public static void main(String[] args) {
        int[] start = {1, 3, 6, 4, 1, 2};
        System.out.println(solution(start));
    }

    public static int solution(int[] A) {
        int result = 0;
        for(int i=0;i<A.length;i++){
            int factor = A[i];
            if(factor+1 <= getMaxValue(A) && !contains (A, factor+1)){
                result = factor+1;
                break;
            }
        }
       return result;

    }
    
    private static int getMaxValue(int[] array){  
        int maxValue = array[0];  
        for(int i=1;i < array.length;i++){  
        if(array[i] > maxValue){  
        maxValue = array[i];  

           }  
       }  
       return maxValue;  
  }  
    
    private static boolean contains(int[] arr, int targetValue) {
	for(int s: arr){
		if(s == targetValue)
			return true;
	}
	return false;
    }

}
