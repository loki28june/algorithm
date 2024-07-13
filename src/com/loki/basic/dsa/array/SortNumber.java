package com.loki.basic.dsa.array;

import java.util.Set;
import java.util.TreeSet;

public class SortNumber {

	public static void main(String[] args) {
		Long number = new Long(4527831962l);
		Set<Byte> sorted = new TreeSet<>();
		while (number > 0) {
			byte l = (byte) (number % 10);
			sorted.add(l);
			number /= 10;
		}

		for (Byte byte1 : sorted) {
			System.out.print(byte1);
		}

	}

}
