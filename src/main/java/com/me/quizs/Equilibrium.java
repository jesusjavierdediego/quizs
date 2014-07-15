package com.me.quizs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author administrator
 */
public class Equilibrium {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] start = {-7, 1, 5, 2, -4, 3, 0};
        solution(start);
    }
    
    static void solution(int A[]) {
        int result = 0;
        int totalSum = 0;
        for(int f: A){
            totalSum += f;
        }
        int i = 0;
        int temporalSum = 0;
        for(int f: A){
            if(totalSum - temporalSum - f == temporalSum){
                System.out.println(i);
            }
            temporalSum += f;
            i++;
        }
        
        
        //return result;
    }
    
}
