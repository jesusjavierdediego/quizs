/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.concurrency.concurrent;

import java.util.*;
import java.util.concurrent.*;

/**
 *
 * @author root
 */
public class CountDownLatchImpl {

    private Random rand = new Random();
    private int distance = rand.nextInt(250);
    private CountDownLatch start;
    private CountDownLatch finish;
    private List<String> horses = new ArrayList<String>();

    public CountDownLatchImpl(String... names) {
        this.horses.addAll(Arrays.asList(names));
    }

    public void run() throws InterruptedException {
        System.out.println("And the horses are stepping up to the gate...");
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch finish = new CountDownLatch(horses.size());
        final List<String> places = Collections.synchronizedList(new ArrayList<String>());
        for (final String h : horses) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        System.out.println(h + " stepping up to the gate...");
                        start.await();
                        int traveled = 0;
                        while (traveled < distance) {
                            // In a 0-2 second period of time....                            
                            Thread.sleep(rand.nextInt(3) * 1000);
                            // ... a horse travels 0-14 lengths                            
                            traveled += rand.nextInt(15);
                            System.out.println(h + " advanced to " + traveled + "!");
                        }
                        finish.countDown();
                        System.out.println(h + " crossed the finish!");
                        places.add(h);
                    } catch (InterruptedException intEx) {
                        System.out.println("ABORTING RACE!!!");
                        intEx.printStackTrace();
                    }
                }
            }).start();
        }
        System.out.println("And... they're off!");
        start.countDown();
        finish.await();
        System.out.println("And we have our winners!");
        System.out.println(places.get(0) + " took the gold...");
        System.out.println(places.get(1) + " got the silver...");
        System.out.println("and " + places.get(2) + " took home the bronze.");
    }
}


