package com.loki.array;
import java.util.Scanner;

class CountSquares {
	
	public static void perfect(long n){
		int k = 1;
	    for(long i = 1; i <= Math.pow(10,18);){
	       i = k * k;
	    	if(i < n){
	            System.out.println(i);
	        }
	        else{
	            break;
	        }
	    	k++;
	     }
	}
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i = 0;i< T;i++){
		    long n = in.nextLong();
		    perfect(n);
		    
		}
	}
}