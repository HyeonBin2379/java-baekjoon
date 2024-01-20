package programmers;

import java.util.Arrays;

class IntegerTriangleSolution {
    public int solution(int[][] triangle) {
        int lineCount = triangle.length;
        int[][] array = new int[lineCount+1][lineCount+1];
        for (int i = 0; i < lineCount; i++) {
            System.arraycopy(triangle[i], 0, array[i+1], 1, triangle[i].length);
        }

        int[][] dp = new int[lineCount+1][lineCount+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + array[i][j];
            }
        }
        Arrays.sort(dp[lineCount]);
        return dp[lineCount][lineCount];
    }
}
public class IntegerTriangle {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(new IntegerTriangleSolution().solution(triangle));
    }
}
