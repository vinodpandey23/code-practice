package com.hackerrank.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArraysLeftRotation {

	// Complete the rotLeft function below.
	static int[] rotLeft(int[] a, int d) {

		int[] result = null;

		if (a != null && a.length > 0 && d > 0) {

			result = rorateIndex(a, 0, d);

		}

		return result;

	}

	static int[] rorateIndex(int a[], int index, int d) {

		int tempVal;

		if (index + d < a.length) {
			tempVal = a[index + d];
		} else {
			tempVal = a[index + d - a.length];
		}

		if (index == a.length - 1) {
			a[index] = tempVal;
		} else {
			rorateIndex(a, index + 1, d);
			a[index] = tempVal;
		}

		return a;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		int[] result = rotLeft(a, d);

		for (int i = 0; i < result.length; i++) {
			bufferedWriter.write(String.valueOf(result[i]));

			if (i != result.length - 1) {
				bufferedWriter.write(" ");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
