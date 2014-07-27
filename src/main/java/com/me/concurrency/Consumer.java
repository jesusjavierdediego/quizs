/*
The Consumer takes the integers and prints them to the output. 
It uses the method take() which retrieves and removes the head of 
the queue and in case an element is not available, it blocks until this element 
becomes available.
 */

package com.me.concurrency;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	protected BlockingQueue queue = null;

	public Consumer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			System.out.println("Consumed: " + queue.take());
			System.out.println("Consumed: " + queue.take());
			System.out.println("Consumed: " + queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
