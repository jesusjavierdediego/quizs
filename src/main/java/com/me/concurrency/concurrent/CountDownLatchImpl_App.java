/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.me.concurrency.concurrent;

/**
 *
 * If Semaphore is the concurrency class designed to allow threads "in" one at 
 * a time (perhaps evoking memories of bouncers at popular nightclubs), then 
 * CountDownLatch is the starting gate at a horse race. This class holds all 
 * threads at bay until a particular condition is met, at which point it releases 
 * them all at once. 
 * 
 */
public class CountDownLatchImpl_App {

    public static void main(String[] args) throws InterruptedException, java.io.IOException {
        System.out.println("Prepping...");
        CountDownLatchImpl r = new CountDownLatchImpl(
                "Beverly Takes a Bath", 
                "RockerHorse", 
                "Phineas", 
                "Ferb", 
                "Tin Cup", 
                "I'm Faster Than a Monkey", 
                "Glue Factory Reject"
        );
        //System.out.println("It's a race of " + r.getDistance() + " lengths");
        System.out.println("Press Enter to run the race....");
        System.in.read();
        r.run();
    }
}
