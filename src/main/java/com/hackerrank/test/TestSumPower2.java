package com.hackerrank.test;

public class TestSumPower2 {

	public static void main(String[] args) {

		long sum = 0;
		for (long i = 1; i <= 4; i++) {
			sum += 1 << i;
		}
		System.out.println(sum);
	}
}
