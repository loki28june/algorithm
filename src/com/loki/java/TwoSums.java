package com.loki.java;

public class TwoSums {
    
    
    private Integer sum1Lock = new Integer(0);
    private Integer sum2Lock = new Integer(0);

    public void add(int val1, int val2){
        synchronized(this.sum1Lock){
            this.sum1Lock += val1;   
        }
        synchronized(this.sum2Lock){
            this.sum2Lock += val2;
        }
        
        System.out.println("sum of value 1 =>"+ sum1Lock + " sum of value 2 =>" + sum2Lock);
    }
    
    public static void main(String[] args){
    	TwoSums ts = new TwoSums();
    	new Thread(){
    		public void run(){
    			ts.add(1, 2);
    		}
    		
    		
    	}.start();
    	
    	new Thread(){
    		public void run(){
    			ts.add(3, 4);
    		}
    		
    		
    	}.start();
    	
    	
    }
    
    
}
