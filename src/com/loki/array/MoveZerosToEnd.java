package com.loki.array;

public class MoveZerosToEnd {
	private int[] arr = { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0 };
	private int length = arr.length;

	public void shiftZerosRightEfficient() {
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}

		while (count < length) {
			arr[count++] = 0;
		}
	}

	public void shiftZerosLeftEfficient() {
		int count = length - 1;
		for (int i = length - 1; i >= 0; i--) {
			if (arr[i] != 0) {
				arr[count--] = arr[i];
			}
		}

		while (count >= 0) {
			arr[count--] = 0;
		}
	}

	public void print() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MoveZerosToEnd me = new MoveZerosToEnd();
		me.print();
		// me.shiftZeros();
		me.shiftZerosRightEfficient();
		me.print();
		me.shiftZerosLeftEfficient();
		me.print();
	}

}
