package codekata.programmers;

import java.util.Arrays;

public class TriangleSnail {

	private int[][] arr;

	public int[] solution(int n) {
		arr = new int[n][n];

		int startRow = 0, startCol = 0, currentNum = 0;
		for (int i = n; i > 0; i--) {
			switch ((n+1-i) % 3) {
				case 1:
					pattern1(startRow, startCol, currentNum, i);
					break;
				case 2:
					pattern2(startRow+i, startCol, currentNum, i);
					break;
				case 0:
					pattern3(startRow+i+1, startCol+i+1, currentNum, i);
					startRow += 2;
					startCol += 1;
					break;
			}
			currentNum += i;
		}
		return Arrays.stream(arr)
				.flatMapToInt(Arrays::stream)
				.filter(value -> value > 0)
				.toArray();
	}

	private void pattern1(int startRow, int startCol, int startNum, int count) {
		int nextNum = startNum;
		for (int i = startRow; i < startRow+count; i++) {
			arr[i][startCol] = ++nextNum;
		}
	}

	private void pattern2(int row, int startCol, int startNum, int count) {
		int nextNum = startNum;
		for (int i = 1; i <= count; i++) {
			arr[row][startCol+i] = ++nextNum;
		}
	}

	private void pattern3(int startRow, int startCol, int startNum, int count) {
		int nextNum = startNum;
		for (int i = 1; i <= count; i++) {
			arr[startRow-i][startCol-i] = ++nextNum;
		}
	}

	public static void main(String[] args) {
		int[] result = new TriangleSnail().solution(5);
		System.out.println(Arrays.toString(result));
	}
}
