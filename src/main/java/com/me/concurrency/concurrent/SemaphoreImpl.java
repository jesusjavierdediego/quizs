/*
In some enterprise systems, it's not uncommon for developers to need to throttle 
the number of open requests (threads/actions) against a particular resource — in fact, 
throttling can sometimes improve the throughput of a system by reducing the amount of 
contention against that particular resource. While it's certainly possible to try
to write the throttling code by hand, it's easier to use the semaphore class, 
which takes care of throttling for you, 
 */
package com.me.concurrency.concurrent;

import java.util.*; 
import java.util.concurrent.*;

/**
 *
 * @author root
 */
public class SemaphoreImpl {

    public static void main(String[] args) {
        Runnable limitedCall = new Runnable() {
            final Random rand = new Random();
            final Semaphore available = new Semaphore(3);
            int count = 0;

            public void run() {
                int time = rand.nextInt(15);
                int num = count++;
                try {
                    available.acquire();
                    System.out.println("Executing " + "long-running action for " + time + " seconds... #" + num);
                    Thread.sleep(time * 1000);
                    System.out.println("Done with #" + num + "!");
                    available.release();
                } catch (InterruptedException intEx) {
                    intEx.printStackTrace();
                }
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(limitedCall).start();
        }
    }

}
