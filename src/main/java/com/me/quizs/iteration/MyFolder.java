package iteration;

import java.util.Iterator;
import java.util.Queue;

public class MyFolder<T, U> implements Folder<T, U>
{

    public U fold(U u, Queue<T> ts, Function2<T, U, U> function)
    {
        if(u == null || ts == null || function == null)
            throw new IllegalArgumentException();

        if (ts.isEmpty()) {
            return u;
        }
        
        //Object ux;
        //ts.parallelStream().forEach(u =function.apply( ts.poll() , u)); System.out::println
        //ts.parallelStream().forEach(System.out::println); 
        //ts.parallelStream().forEach(ux -> function.apply( ts.poll() , u)); 
//        ts.parallelStream().forEach((u) -> function.apply( ts.poll() , u));
//        return u;

        // The recursive implementation will overflow the stack for
        // any data set of real size, your job is to implement a
        // non-recursive solution
        // return fold(function.apply(ts.poll(), u), ts, function);
        //return null;

        
        //return ts.parallelStream().forEach((U ux) -> function.apply( ts.poll(), u));

        
    
        Iterator<T> it = ts.iterator(); 
        while (it.hasNext()) {
            u = function.apply(ts.poll(), u); 
        } 

        return u;
    }
}