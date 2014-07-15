package com.me.quizs;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;



public class WordifiedNumberImpl implements WordifiedNumber {

    
    /*
    First of all we declare final instance variables to be used to build number words.
    These data could be stored in static configuration files out of the Java artifact.
    There are 3 main lists: units, tens and big numbers (thousand and beyond).
    Values never change.
    */
    
    //Numbers 0-19
    final static String conjunction = "and";
    final static String hundred = "hundred";
    final static String decimalFormat = "###,###.###";
    final static String separator = ",";
    final static String[] units = {"zero","one","two","three","four",
		"five","six","seven","eight","nine","ten",
		"eleven","twelve","thirteen","fourteen","fifteen",
		"sixteen","seventeen","sighteen","nineteen"};
    //The position in the collection is important. So, positions 0 (0-9) and 1 (10-19) in the array are empty.
    final static String[] tens = {"","","twenty","thirty","forty","fifty",
		"sixty","seventy","eighty","ninety"};
    
    //The solution is now scalable by adding new values in the qualifiers array.
    //The series can be extended beyond but the current limit is billions.
    final static String[][] qualifiers = new String[][]{
        { "0",""},
        { "1","thousand" },
        { "2","million" },
        { "3","billion" }
      };
    //...
    
    /*
    Internationalization
    Other languages can be displayed by including locale values.
    
    final static String conjunction = "y";
    final static String hundred = "cien";
    final static String decimalFormat = "###,###.###";
    final static String separator = ".";
    final  static String[] units = {"cero","uno","dos","tres","cuatro",
		"cinco","seis","siete","ocho","nueve","diez",
		"once","doce","trece","catorce","quince",
		"dieciseis","diecisiete","dieciocho","diecinueve"};
    final static String[] tens = {"","","veinte","treinta","cuarenta","cincuenta",
		"sesenta","sesenta","ochenta","noventa"};
    final static String[][] qualifiers = new String[][]{
        { "0",""},
        { "1","mil" },
        { "2","millon" },
        { "3","billon" }
      };
    */
    
    
    
     
     //public static void main(String[] args){
    @Override
    public String toWords(int i){
        String formattedNumber = customFormat(i);
        StringTokenizer st = new StringTokenizer(formattedNumber, separator);
        String[] groups = new String[st.countTokens()];
        String[] result = new String[st.countTokens()];
        int counter = 0;
        while (st.hasMoreTokens()) {
            groups[counter] = st.nextToken();
            counter++;
        }
        
        List<String> groupsList = Arrays.asList(groups);
        Collections.reverse(groupsList);
        
        int suffix = 0;
        StringBuffer sb = new StringBuffer();
        for(String s : groupsList){
            String literal = calculate (Integer.parseInt(s));
            for (int c = 0; c < qualifiers.length; c++) {  
                //System.out.println("sooo: " + qualifiers[c][0]);
                if(suffix == Integer.parseInt(qualifiers[c][0])){
                    for (int d = 0; d < qualifiers[c].length; d++) {  
                        //String p1 = qualifiers[c][d];  
                        //System.out.println(qualifiers[c][d]);
//                        if(qualifiers[0][d].equals("0")){
//                            result[suffix] = literal + " " + qualifiers[c][d];
//                        } else{
//                            result[suffix] = literal + qualifiers[c][d];
//                        }
                       result[suffix] = literal + " " + qualifiers[c][d];
                    }  
                }
                
            }  
            suffix++;
        }
        
        
        List<String> resultList = Arrays.asList(result);
        Collections.reverse(resultList);
        
        int position = 1;
        for(String s:resultList){
            sb.append(s);
            if(position != resultList.size())
                sb.append(conjunction);
            position++;
        }
        
       System.out.println("RESULT: " + sb);
       return sb.toString();
         
     }
     
     
     /*
        The calculation of literals method is based on a method with controlled/limited recursive logic.
        Passed argument never will be greater than 999.
        Recursivity allow us to use the same logic to carry out subsequent operations 
        with the same logic.
        The solution IS scalable because a wider range of numbers will not require changes 
        in the implementation, only in data from arrays (qualifiers array) Data in this array could be 
        stored in static configuration and not in code).
    
        An alternative iterative solution is always possible. The best solution should be 
        adapted to several factors such as Concurrency, Parallelism conditions, CPU architecture, etc.
    */
     private String calculate (int i ) {
        //Units: First, check if the number is in the range 0-19 (instance var 'units').
        if (i < 20) {
            //Directly returns the value in the array
            return units[i];
        }
        //Tens: If not, check if the number is below 100 (instance var 'tens').
        //Recursivity starts here, to write module units.
        if (i < 100) {
            return tens[i / 10] + ((i % 10 > 0) ? " " + calculate(i % 10) : "");
        }
        return units[i / 100] + " " + hundred + ((i % 100 > 0) ? " " + conjunction + " " + calculate(i % 100) : "");
     }


    /*
     private method to return the formatted number
     */
    private String customFormat(double value ) {
      DecimalFormat myFormatter = new DecimalFormat(decimalFormat);
      
      return myFormatter.format(value);
   }
}
