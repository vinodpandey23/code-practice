package com.hackerrank.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SherlockAnagrams {

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {

		int result = 0;

		if (s != null) {
			for (int index = 1; index < s.length(); index++) {
				for (int i = 0; i < s.length() - index + 1; i++) {
					String s1 = s.substring(i, i + index);
					for (int j = i + 1; j < s.length() - index + 1; j++) {
						String s2 = s.substring(j, j + index);
						if (checkAnagram(s1, s2)) {
							result++;
						}
					}
				}
			}
		}

		return result;

	}

	static boolean checkAnagram(String s1, String s2) {

		if (s1.equals(s2)) {
			return true;
		}

		List<Character> s1List = new ArrayList<Character>();
		List<Character> s2List = new ArrayList<Character>();

		for (int i = 0; i < s1.length(); i++) {
			s1List.add(s1.charAt(i));
			s2List.add(s2.charAt(i));
		}

		for (Character c : s1List) {

			s2List.remove(c);

		}

		if (s2List.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s = scanner.nextLine();

			int result = sherlockAndAnagrams(s);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
