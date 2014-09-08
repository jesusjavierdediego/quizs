/*
The Producer adds random integers (between 0 and 100) and 
puts the result of the addition to a shared BlockingQueue.
 */

package com.me.concurrency.concurrent.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue bq = null;

	public Producer(BlockingQueue queue) {
		this.setBlockingQueue(queue);
	}

	public void run() {

		Random rand = new Random();
		int res = 0;
		try {
			res = Addition(rand.nextInt(100), rand.nextInt(50));
			System.out.println("Produced: " + res);
			bq.put(res);
			Thread.sleep(1000);
			res = Addition(rand.nextInt(100), rand.nextInt(50));
			System.out.println("Produced: " + res);
			bq.put(res);
			Thread.sleep(1000);
			res = Addition(rand.nextInt(100), rand.nextInt(50));
			System.out.println("Produced: " + res);
			bq.put(res);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setBlockingQueue(BlockingQueue bq) {
		this.bq = bq;
	}

	public int Addition(int x, int y) {
		int result = 0;
		result = x + y;
		return result;
	}

}
