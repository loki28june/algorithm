package com.loki.array;

import java.util.ArrayList;
import java.util.List;

// Search, insert and delete in an unsorted array
public class ArrayOperations {
	private static int[] arr = {5,2,1,6,9,7};
	private static List<Integer> arrList = new ArrayList<>();
	
	public static int search(int item){
		boolean found = false;
		int i;
		for(i = 0 ; i< arr.length ; i++){
			if(arr[i] == item){
				found = true;
				//System.out.println("found at position "+(i+1));
				return i+1;
			}
		}
		return -1;
	}
	
	public static int[] insert(int item){
		int[] newArr = new int[arr.length + 1];
		int j =0;
		for(int i=0;i< arr.length ;i++){
			newArr[j] = arr[i];
			j++;
		}
		
		newArr[j] = item;
		return newArr;
		
	}
	
	public static void delete(int item){
		int index = search(item) - 1;
		int i;
		for(i = index; i< arr.length - 1 ; i++){
			arr[i] = arr[i + 1];
		}
		System.out.println("array after deleting item " + item);
		arr[i] = 0;
		print();
		
		
	}
	
	public static void print(){
		for(int i: arr){
			System.out.print(i+ " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		print();
	  System.out.println("index of item is " + search(9));
	  insert(28);
	  delete(1);
		

	}

}
