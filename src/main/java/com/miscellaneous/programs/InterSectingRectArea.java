package com.miscellaneous.programs;

public class InterSectingRectArea {

	public static void main(String[] args) {
		
		System.out.println();
		
	}

	public static int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
		int left = Math.max(K, P);
		int right = Math.min(M, R);
		int bottom = Math.max(L, Q);
		int top = Math.min(N, S);

		if (left < right && bottom < top) {
			int interSection = (right - left) * (top - bottom);
			int unionArea = ((M - K) * (N - L)) + ((R - P) * (S - Q)) - interSection;
			return unionArea;
		}
		return 0;
	}

}
