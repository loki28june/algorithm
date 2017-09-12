package com.loki.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// blocking queue implementation
public class ProducerConsumerDemo {

	public static void main(String[] args) {
		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();
		Thread p1 = new Thread(new Producer(sharedQueue));
		Thread c1 = new Thread(new Consumer(sharedQueue));

		p1.start();
		c1.start();

	}

}

class Producer implements Runnable{
	private final BlockingQueue<Integer> sharedQueue;
	
	public Producer(BlockingQueue<Integer> sharedQ){
		this.sharedQueue = sharedQ;
	}

	@Override
	public void run() {
		for(int i = 0; i< 8; i++){
			try {
				sharedQueue.put(i);
				System.out.println("produced "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable{

	private final BlockingQueue<Integer> sharedQueue;
	
	public Consumer(BlockingQueue<Integer> sharedQ){
		this.sharedQueue = sharedQ;
	}

	@Override
	public void run(){
		while(true){
			try {
				System.out.println("consumed "+sharedQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
