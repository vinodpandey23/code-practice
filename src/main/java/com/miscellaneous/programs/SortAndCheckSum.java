package com.miscellaneous.programs;

import java.util.HashMap;
import java.util.Map;

public class SortAndCheckSum {

	static int arr[] = new int[] { 1, 5, 7, -1, 5 };

	public static void main(String args[]) {

		System.out.println(getPairCount(arr, 6));
		arr = new int[] { 2, 4, 3, 3 };
		System.out.println(getPairCount(arr, 6));
	}

	public static int getPairCount(int[] arr, int sum) {

		Map<Integer, Integer> occurances = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			if (!occurances.containsKey(arr[i])) {
				occurances.put(arr[i], 1);
			} else {
				occurances.put(arr[i], occurances.get(arr[i]) + 1);
			}
		}

		int counter = 0;

		for (int i = 0; i < arr.length; i++) {

			if (occurances.get(sum - arr[i]) != null) {
				counter += occurances.get(sum - arr[i]);
			}

			if (sum - arr[i] == arr[i]) {
				counter--;
			}

		}

		return counter / 2;

	}

}
