package com.loki.array.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.loki.array.BinarySearchRecursion;

public class ArrayTest {
	
	@Test
	public void searchUsingBinarySearchShouldReturnCorrectValue() {
		BinarySearchRecursion binarySearch = new BinarySearchRecursion();
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		
		assertEquals(1, binarySearch.binarySearch(0, arr.length-1, arr, 1));
		assertEquals(2, binarySearch.binarySearch(0, arr.length-1, arr, 2));
		assertEquals(3, binarySearch.binarySearch(0, arr.length-1, arr, 3));
		assertEquals(4, binarySearch.binarySearch(0, arr.length-1, arr, 4));
		assertEquals(5, binarySearch.binarySearch(0, arr.length-1, arr, 5));
		assertEquals(6, binarySearch.binarySearch(0, arr.length-1, arr, 6));
		
	}
	
	@Test
	public void valueNotPresentInArrayShouldReturnMinusOne() {
		BinarySearchRecursion binarySearch = new BinarySearchRecursion();
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		
		assertEquals(-1, binarySearch.binarySearch(0, arr.length-1, arr, 10));
	}

}
