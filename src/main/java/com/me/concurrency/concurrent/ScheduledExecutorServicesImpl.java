/*
As great as the ExecutorService interface is, certain tasks need to be done in a 
scheduled fashion, such as executing a given task at determined intervals or at a 
specific time. This is the province of the ScheduledExecutorService, which extends 
ExecutorService.
If your goal was to create a "heartbeat" command that "pinged" every five seconds, 
ScheduledExecutorService would make it as simple as below.
 */
package com.me.concurrency.concurrent;

import java.util.concurrent.*;

/**
 *
 * @author root
 */
public class ScheduledExecutorServicesImpl {

    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        Runnable pinger = new Runnable() {
            public void run() {
                System.out.println("PING!");
            }
        };
        ses.scheduleAtFixedRate(pinger, 5, 5, TimeUnit.SECONDS);
    }
}
