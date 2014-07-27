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
public class QRound {
     public static void main(String[] args) {
        int start = 2;
        System.out.println(solution(start));
    }

    public static int solution(int Q) {
        int result = 0;
        
        for(int i=-Q;i<Q;i++){
            for(int j =-Q;j<=Q;j++){
                System.out.println("j: " + j);
                if((i*i) + (j*j) == Q){
                    result++;
                }
            }
        }
        
        
        return result;
    }
}
