package com.hackerrank.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CompareTriplets {

	// Complete the compareTriplets function below.
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

		List<Integer> result = null;

		if (a == null || b == null || a.size() != 3 || b.size() != 3) {
			return result;
		} else {

			result = new ArrayList<>();

			result.add(0);
			result.add(0);

			for (int i = 0; i < 3; i++) {

				if (a.get(i) > b.get(i)) {
					result.set(0, result.get(0) + 1);
				} else if (a.get(i) < b.get(i)) {
					result.set(1, result.get(1) + 1);
				}

			}

			return result;

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> a = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a.add(aItem);
		}

		String[] bItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> b = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			int bItem = Integer.parseInt(bItems[i]);
			b.add(bItem);
		}

		List<Integer> result = compareTriplets(a, b);

		for (int i = 0; i < result.size(); i++) {
			bufferedWriter.write(String.valueOf(result.get(i)));

			if (i != result.size() - 1) {
				bufferedWriter.write(" ");
			}
		}

		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
