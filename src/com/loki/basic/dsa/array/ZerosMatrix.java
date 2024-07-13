package com.loki.basic.dsa.array;

public class ZerosMatrix {
	//private static int[][] input = { { 2, 3, 0 }, { 7, 2, 2 }, { 4, 0, 2 } };
	
	private static int[][] input = { { 2, 3, 1, 2 }, { 7, 2, 2 , 1}, { 4, 0, 2 , 7} };
	
	private static int rows = input.length;
	private static int columns = input[0].length;
	
	public static void print(){
		
		System.out.println("printing 2-d array ");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(input[i][j] + " ");
			}
			
			System.out.println();
		}
		
	}
	

	public static void main(String[] args) {
		
		boolean isFirstRowZero = false;
		boolean isFirstColZero = false;

		print();
		
		// finding out whether first row needed to be zero
		for (int i = 0; i < columns; i++) {
			if (input[0][i] == 0) {
				isFirstRowZero = true;
				break;
			}
		}

		// finding out whether first columns needed to be zero
		for (int j = 0; j < rows; j++) {
			if (input[j][0] == 0) {
				isFirstColZero = true;
				break;
			}
		}

		// iterating over the 2d-array to find out the position of zero and accordingly updating first rows and first column
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				if(input[i][j] == 0){
					input[i][0] = 0;
					input[0][j] = 0;
				}
			}
		}
		
		// making required rows zero
		for(int i = 1 ; i< columns ; i++){
			if (input[0][i] == 0) {
				for(int j = 1; j < rows; j++){
					input[j][i] = 0;
				}
				
			}
		}
		// making required columns zero
		for(int i = 1 ; i< rows ; i++){
			if (input[i][0] == 0) {
				for(int j = 1; j < columns; j++){
					input[i][j] = 0;
				}
				
			}
		}
		
		if(isFirstRowZero){
			for(int j = 0; j < rows ; j++){
				input[0][j] = 0;
			}
		}
		
		if(isFirstColZero){
			for(int i = 0 ; i < columns; i++){
				input[i][0] = 0;
			}
			
		}
		
		// printing arrays
		print();
		

	}

}
