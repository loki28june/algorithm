package com.loki.randomproblems.sort;

public class SelectionSort {
	int [] arr = {64, 25, 12, 22, 11};

	
	public void selectionSort(){
		int min;
		for(int i = 0; i< arr.length - 1; i++){
			min = i;
			for(int j = i+1; j < arr.length; j++){
				if(arr[j] < arr[min]){
					min = j;
				}
			}
			if(min == i) continue;
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		
	}
	
	public void print() {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		SelectionSort s = new SelectionSort();
		s.print();
		s.selectionSort();
		s.print();

	}

}
