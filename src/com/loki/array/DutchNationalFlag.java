package com.loki.array;

public class DutchNationalFlag {
	int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
	int n = arr.length;

	public void print() {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public void sort() {
		int countZero = 0, countOne = 0, countTwo = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				countZero++;
			} else if (arr[i] == 1) {
				countOne++;
			} else {
				countTwo++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (countZero > 0) {
				arr[i] = 0;
				countZero--;
				continue;
			}

			if (countOne > 0) {
				arr[i] = 1;
				countOne--;
				continue;
			}

			if (countTwo > 0) {
				arr[i] = 2;
				countZero--;
				continue;
			}
		}
	}

	public void efficientSort() {
		int low = 0, mid = 0, high = n - 1, temp = 0;
		while (mid <= high) {
			switch (arr[mid]) {

			case 0:
				temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				mid++;
				low++;
				break;

			case 1:
				mid++;
				break;

			case 2:
				temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				high--;
				break;
			}
		}
	}

	public static void main(String[] args) {
		DutchNationalFlag dtf = new DutchNationalFlag();
		dtf.print();
		//dtf.sort();
		dtf.efficientSort();
		dtf.print();

	}

}
