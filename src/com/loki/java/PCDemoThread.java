package com.loki.java;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class PCDemoThread {

	public static void main(String[] args) {
		PC pc = new PC();
		
		Thread p1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try{
				pc.produce();	
					
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				
			}
		});
		
		Thread c1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try{
				pc.consume();	
					
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				
			}
		});
		p1.start();
		c1.start();
		/*p1.join();
		c1.join();*/
	}

}

class PC {
	
	private final int capacity = 2;
	private int value = 0 ;
	private LinkedList<Integer> sharedList = new LinkedList<Integer>();
	PC(){
		
	}
	
	
	public void produce() throws InterruptedException
	{
		
		while(true){
		synchronized(this){
			while(sharedList.size() == capacity){
				wait();
			}

			System.out.println("produced "+ value);
			sharedList.add(value++);
			notify();
			Thread.sleep(1000);
		}
		}
	}
	
	public void consume() throws InterruptedException
	{
		while(true){
		Thread.sleep(1000);
		
		synchronized (this) {
			while(sharedList.size() == 0){
				wait();
			}
			int value = sharedList.removeFirst();
			System.out.println("consumed "+value);
			
			notify();
			
			Thread.sleep(1000);
		}
	}
	}
}
