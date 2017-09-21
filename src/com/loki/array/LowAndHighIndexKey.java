package com.loki.array;

public class LowAndHighIndexKey {
	private int[] arr = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };

	public void findRepeating() {
		int[] indexArr = new int[150];

		for (int i = 0; i < arr.length; i++) {
			int a = arr[i];
			indexArr[a] = ++indexArr[a];
		}

		int max = 0;
		for (int i = 0; i < indexArr.length; i++) {
			if (indexArr[i] > max) {
				max = indexArr[i];
			}
		}
		System.out.println("most repeated charachter is " + (max + 1));
	}

	/*
	 * @Deprecated public void findFirstAndLastIndex(int x) { int first = -1,
	 * last = -1; for (int i = 0; i < arr.length; i++) { if (arr[i] == x) { if
	 * (first == -1) { first = i; last = i; } else { last = i; } } }
	 * 
	 * System.out.println("first index is => " + first);
	 * System.out.println("last index is => " + last); }
	 */

	public void findFirstAndLastIndex(int x) {
		int low = 0, high = arr.length - 1;
		int leftIndex = leftBinarySearch(low, high, x);
		int rightIndex = rightBinarySearch(low, high, x);
		if (leftIndex != 1 && rightIndex != -1) {
			System.out.println("left index is " + leftIndex);
			System.out.println("right index is " + rightIndex);
		}

	}

	public int rightBinarySearch(int low, int high, int x) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid == arr.length - 1 || x < arr[mid + 1] && arr[mid] == x) {
				return mid;
			} else if (x < arr[mid]) {
				high = mid - 1;

			} else {
				low = mid + 1;

			}
		}
		return -1;
	}

	// { 1, 3, 5, 5, 5, 5, 67, 123, 125 };

	public int leftBinarySearch(int low, int high, int x) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid == 0 || arr[mid - 1] < x &&  arr[mid] == x) {
				return mid;
			} else if (arr[mid] < x) {
				low = mid + 1;

			} else {
				high = mid - 1;

			}
		}
		return -1;
	}

	public static void main(String[] args) {
		LowAndHighIndexKey l = new LowAndHighIndexKey();
		l.findFirstAndLastIndex(5);

	}

}
