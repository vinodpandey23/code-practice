package com.hackerrank.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JumpingOnClouds {

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {

		int jumps = 0;

		if (c != null && c.length >= 2) {

			for (int i = 0; i < c.length;) {

				if (i == c.length - 1) {
					break;
				}

				if (i != c.length - 2) {

					if (c[i + 2] == 0) {

						i += 2;

					} else if (c[i + 2] == 1) {

						i += 1;

					} else {
						return 0;
					}

				} else {
					i += 1;
				}

				jumps++;

			}

		}

		return jumps;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int result = jumpingOnClouds(c);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
