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
public class ArrayP {
     public static void main(String[] args) {
        //int[] start = {2, 3, -1, 1, 3};
        int[] start = {1, 1, -1, 1};
        System.out.println(solution(start));
    }

    public static int solution(int[] A) {
        int result = 0;

        
        
        for(int i = 0;i<A.length;i++){
            try{
                if((A[i]) == -A[i+A[i]]){
                    return -1;
                }
                int value = A[i+A[i]];
                result++;
            }catch(ArrayIndexOutOfBoundsException e){
                break;
            }
        }
        
        
        return result;
    }
}
