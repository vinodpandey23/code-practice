package com.hackerrank.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulation {

	static long arrayManipulation(int n, int[][] queries) {

		long[] arr = new long[n + 1];

		for (int i = 0; i < queries.length; i++) {
			int startIndex = queries[i][0];
			int endIndex = queries[i][1];
			int number = queries[i][2];

			arr[startIndex - 1] += number;
			arr[endIndex] -= number;

		}

		long maxNumber = arr[0];
		for (int i = 1; i < n; i++) {

			arr[i] = arr[i - 1] + arr[i];

			if (arr[i] > maxNumber) {
				maxNumber = arr[i];
			}

		}

		return maxNumber;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		int[][] queries = new int[m][3];

		for (int i = 0; i < m; i++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 3; j++) {
				int queriesItem = Integer.parseInt(queriesRowItems[j]);
				queries[i][j] = queriesItem;
			}
		}

		long result = arrayManipulation(n, queries);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
