package com.loki.array;

public class KthElementSortedArrays {

	public int findKthElement(int[] a, int[] b) {
		return 0;
	}

	public static int[] mergeArrays(int[] a, int[] b) {
		int l1 = a.length;
		int l2 = b.length;
		int[] newArray = new int[l1 + l2];
		int i = 0, j = 0, k = 0;

		while (i < l1 && j < l2) {
			if (a[i] < b[j]) {
				newArray[k] = a[i];
				k++;
				i++;
			} else {
				newArray[k] = b[j];
				k++;
				j++;
			}
		}

		while (j < l2) {
			newArray[k] = b[j];
			k++;
			j++;
		}

		while (i < l1) {
			newArray[k] = a[i];
			k++;
			i++;
		}

		return newArray;
	}

	public static void printArray(int[] arr) {
		for (int no : arr) {
			System.out.print(no + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 4, 5 };
		int[] arr2 = { 2, 6, 7, 8, 9 };
		int[] mergedArray = mergeArrays(arr1, arr2);
		// printArray(mergedArray);
		int k = 5;
		System.out.println("kth element is " + mergedArray[k - 1]);

	}

}
