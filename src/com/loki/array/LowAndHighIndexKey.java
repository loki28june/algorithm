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

	public void findFirstAndLastIndex(int x) {
		int first = -1, last = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				if (first == -1) {
					first = i;
					last = i;
				} else {
					last = i;
				}
			}
			}

		System.out.println("first index is => " + first);
		System.out.println("last index is => " + last);
	}

	public static void main(String[] args) {
		LowAndHighIndexKey l = new LowAndHighIndexKey();
		l.findFirstAndLastIndex(5);

	}

}
