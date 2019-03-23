package com.hackerrank.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	// Complete the countTriplets function below.
	static long countTriplets(List<Long> arr, long r) {

		long result = 0;

		if (arr != null && r > 0) {

			Map<Long, List<Integer>> indexes = new HashMap<>();

			int counter = 0;
			for (Long item : arr) {

				if (!indexes.containsKey(item)) {
					indexes.put(item, new ArrayList<Integer>());
				}

				indexes.get(item).add(counter);
				counter++;
			}

			counter = -1;
			for (Long item : arr) {

				counter++;

				if (item % r != 0) {
					continue;
				}

				if (item * r > Integer.MAX_VALUE) {
					continue;
				}

				Long first = item / r;
				Long last = item * r;

				result += findCount(indexes, first, last, counter);

			}
			System.out.println(counter);

		}

		return result;
	}

	static long findCount(Map<Long, List<Integer>> indexes, long first, long last, int index) {

		if (!indexes.containsKey(first) || !indexes.containsKey(last)) {
			return 0;
		}

		List<Integer> firstIndexes = indexes.get(first);
		List<Integer> lastIndexes = indexes.get(last);

		int r1 = Collections.binarySearch(firstIndexes, index);
		if (r1 < 0) {
			r1 = -1 - r1;
		}

		int r2 = Collections.binarySearch(lastIndexes, index);
		if (r2 < 0) {
			r2 = -1 - r2 - 1;
		}

		r2 = lastIndexes.size() - 1 - r2;

		System.out.println(r1 + " * " + r2);
		return r1 * r2;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(nr[0]);

		long r = Long.parseLong(nr[1]);

		String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Long> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			long arrItem = Long.parseLong(arrItems[i]);
			arr.add(arrItem);
		}

		long ans = countTriplets(arr, r);

		System.out.println(ans);

		// bufferedWriter.write(String.valueOf(ans));
		// bufferedWriter.newLine();

		bufferedReader.close();
		// bufferedWriter.close();
	}
}
