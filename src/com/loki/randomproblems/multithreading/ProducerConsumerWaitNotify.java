package com.loki.randomproblems.multithreading;

import java.util.LinkedList;

public class ProducerConsumerWaitNotify {

	public static class PC {
		private LinkedList<Integer> list = new LinkedList<>();
		int capacity = 2;

		public void produce() {
			int value = 0;
			while (true) {
				synchronized (this) {
					try {
						while (list.size() == capacity) {
							wait();
						}

						System.out.print("Produced " + value);
						System.out.println();
						list.add(value++);
						notify();

						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}

		}

		public void consume() {
			while (true) {
				synchronized (this) {

					try {
						while (list.size() == 0) {
							wait();
						}

						System.out.print("Consumed " + list.removeFirst());
						System.out.println();
						notify();

						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {

		final PC pc = new PC();

		Thread t1 = new Thread(() -> pc.produce());
		Thread t2 = new Thread(() -> pc.consume());

		t1.start();
		t2.start();
		t1.join();
		t2.join();

	}
}
