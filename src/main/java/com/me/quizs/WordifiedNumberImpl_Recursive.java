package com.me.quizs;



public class WordifiedNumberImpl_Recursive implements WordifiedNumber {

    
    /*
    First of all we declare final instance variables to be used to build number words.
    There are 3 main lists: units, tens and big numbers (thousand and beyond).
    Final modifier (values never change) makes vars thread safe.
    */
    
    //Numbers 0-19
    final  static String[] units = {"zero","one","two","three","four",
		"five","six","seven","eight","nine","ten",
		"eleven","twelve","thirteen","fourteen","fifteen",
		"sixteen","seventeen","sighteen","nineteen"};
    //The position in the collection is important. So, positions 0 (0-9) and 1 (10-19) in the array are empty.
    final static String[] tens = {"","","twenty","thirty","forty","fifty",
		"sixty","seventy","eighty","ninety"};
    
    //The series can be extended beyond but the current limit is billions.
    final static String[] big = {"thousand", "million", "billion"};
    

    /*
    The shown solution is based on a method with recursive logic.
    Recursivity allow us to use the same logic to carry out subsequent operations 
    with the same logic.
    The problem is, the solution is NOT scalable. A wider range of number will require
    changes in code.
    
    An alternative iterative solution is always possible. The best solution should be 
    adapted to several factors such as Concurrency, Parallelism conditions, CPU architecture, etc.
    */
    @Override
    public String toWords(int i) {
        
        String result = null;
        //Units: First, check if the number is in the range 0-19 (instance var 'units').
        if (i < 20) {
            //Directly returns the value in the array
            return units[i];
        }
        //Tens: If not, check if the number is below 100 (instance var 'tens').
        //Recursivity starts here, to write module units.
        if (i < 100) {
            if(i % 10 > 0){
                result = toWords(i % 10);
            }
            return tens[i / 10] + " " + result;
            //return tens[i / 10] + ((i % 10 > 0) ? " " + wordifiedWordReference(i % 10) : "");
        }
        //Hundreds: If is minor than 1000 detect hundreds and recursively invoke the method to check the remnant. 
        if (i < 1000) {
            if(i % 100 > 0){
                result = " and " + toWords(i % 100);
            }else{
                result = "";
            }
            return units[i / 100] + " hundred" +  result;
            //return units[i / 100] + " hundred" + ((i % 100 > 0) ? " and " + wordifiedWordReference(i % 100) : "");
        }
        //Thousands..
        if (i < 1000000) {
            return toWords(i / 1000) + " thousand " + ((i % 1000 > 0) ? "and " + toWords(i % 1000) : "");
        }
        
        //millions..
        if (i < 1000000) {
            return toWords(i / 100000) + " million " + ((i % 1000 > 0) ? "and " + toWords(i % 1000) : "");
        }
        
        //Billions..
        return (String) toWords(i / 1000000) + " million " + ((i % 1000000 > 0) ? " " + toWords(i % 1000000) : "");
        
        //..
    }
}
