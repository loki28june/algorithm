package com.loki.basic.dsa.array;

public class RearrangePositiveNegative {
	int[] a = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
	int n = a.length;

	public void exchange(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

	}
	
	public int partition() {
		int pivot = 0, low = 0, high = n - 1;
		while (low <= high) {
			while (a[low] < pivot) {
				low++;
			}

			while (a[high] > pivot) {
				high--;
			}

			if (low <= high) {
				int temp = a[low];
				a[low] = a[high];
				a[high] = temp;
				low++;
				high--;
			}
		}
		return low;
	}
	
	public void alternateNumbers(int posIndex){
		int negIndex = 0;
		
		while(negIndex < posIndex && posIndex < n){
			int temp = a[negIndex];
			a[negIndex] = a[posIndex];
			a[posIndex] = temp;
			negIndex = negIndex + 2;
			posIndex++;
		}
	}

	public void print() {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	
	public static void main(String[] args) {
		RearrangePositiveNegative qs = new RearrangePositiveNegative();
		qs.print();
		int posIndex = qs.partition();
		qs.alternateNumbers(posIndex);
		qs.print();

	}

}
