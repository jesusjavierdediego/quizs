/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 *
 * @author JRDO
 */
public class NewClass {
    
    public static void main(String[] args) throws InterruptedException {
        String a = "foo";
        String b = "food".substring(0, 3);
        String c = b.intern();

        if (a.equals(b)) {
            if (a.equals(b)) {
                System.out.println("1");
            } else if (a == c) {
                System.out.println("2");
            } else {
                System.out.println("3");
            }
        } else {
            System.out.println("4");
        }
    }
    
}
