package com.loki.basic.dsa.test;

class MyCode {
	public static void main(String[] args) {

		String result = printCharWithRepetitionNo("aaabba");
		System.out.println("aaabba =>" + result);

	}

	public static String printCharWithRepetitionNo(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length();) {
			int count = 1;
			char c = str.charAt(i);
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(j) != c) {
					break;

				} else {
					count++;
				}
			}

			sb.append(String.valueOf(c)).append(String.valueOf(count));
			i = i + count;

		}

		return sb.toString();

	}
}
