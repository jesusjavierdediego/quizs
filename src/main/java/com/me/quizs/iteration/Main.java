/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iteration;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author JRDO
 */
public class Main {
//    public static void main(String[] args){
//        MyClass c = new MyClass();
//        //U u, Queue<T> ts, Function2<T, U, U> function
//        String st = "";
//        SynchronousQueue q = new SynchronousQueue();
//        class Function2Impl implements Function2{
//            //R apply(T t, U u);
//            public Object apply(Object t, Object u){
//                // do something
//            }
//        }
//        Function2 f2 = new Function2Impl();
//        c.fold(st, q, f2);
//    }
    
    public static void main(String[] args) {

        Folder<Integer,Integer> folder = new MyFolder<Integer, Integer>();

        Queue<Integer> q = new LinkedList<Integer>();

        for(int lop =0; lop < 1000000; lop++ ){ //add some values in the Queue
            q.add(lop);
        }
        Object result = folder.fold(0, q, new Function2<Integer, Integer, Integer>() {
            public Integer apply(Integer val1, Integer val2) {
                return val1 + val2;
            }
        });

        System.out.println("Result: " + result);
    }
}
