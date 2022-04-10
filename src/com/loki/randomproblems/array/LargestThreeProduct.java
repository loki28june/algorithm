package com.loki.randomproblems.array;

public class LargestThreeProduct {
	private int[] arr = { -4, -8, -5, -2, 9, -1, -4 };

	public int largestSum() {
		int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE, z = Integer.MIN_VALUE;
		int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > x) {
				z = y;
				y = x;
				x = arr[i];
			} else if (arr[i] > y) {
				z = y;
				y = arr[i];
			} else if (arr[i] > z) {
				z = arr[i];

			}

			if (arr[i] < a) {
				b = a;
				a = arr[i];
			} else if (arr[i] < b) {
				b = arr[i];
			}
		}

		return Math.max(x*y*z, x*a*b);
	}

	public static void main(String[] args) {
		LargestThreeProduct tl = new LargestThreeProduct();
		System.out.println("maximum product is =>" + tl.largestSum());
	}
}
