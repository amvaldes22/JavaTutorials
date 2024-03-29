package com.omega;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTimeout {

	public static void main (String[] args) {		
		final ReentrantLock lock1 = new ReentrantLock();
		final ReentrantLock lock2 = new ReentrantLock();
		System.out.println("About to create two threads...");
		Runnable try1_2 = getRunnable(lock1, "lock 1", lock2, "lock 2");
		Runnable try2_1 = getRunnable(lock2, "lock 2", lock1, "lock 1");
		new Thread(try1_2).start();
		new Thread(try2_1).start();
		//new Thread(try1_2).start();
		new Thread(try2_1).start();
	}

	private static Runnable getRunnable(final ReentrantLock lock1, final String lock1Name, final ReentrantLock lock2, final String lock2Name) {
		return new Runnable() {
			@Override
			public void run() {
				try {
					if (lock1.tryLock(1, TimeUnit.SECONDS)) {
						System.out.println(lock1Name + " acquired in thread " + Thread.currentThread().getName());
						if (lock2.tryLock(1, TimeUnit.SECONDS)) {
							System.out.println(lock2Name + " acquired in thread " + Thread.currentThread());
							Thread.sleep(2000);
						} else {
							System.out.println("Could not acquire "+lock2Name + " in thread " + Thread.currentThread().getName());
							lock1.unlock();
							System.out.println(lock1Name + " released in thread " + Thread.currentThread().getName());
						}
					} else {
						System.out.println("Could not acquire " + lock1Name + " in thread " + Thread.currentThread().getName());
					}
				} catch (InterruptedException e) {
					//you should not ignore it
				} finally {
					if (lock1.isHeldByCurrentThread()) lock1.unlock();
					if (lock2.isHeldByCurrentThread()) lock2.unlock();
				}
			}
		};
	}

}
