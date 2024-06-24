package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise9252 {
    private static int[][] dp;
    private static char[] strA, strB;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        strA = br.readLine().toCharArray();
        strB = br.readLine().toCharArray();
        br.close();

        dp = new int[strA.length+1][strB.length+1];
        for (int i = 1; i <= strA.length; i++) {
            for (int j = 1; j <= strB.length; j++) {
                if (strA[i-1] == strB[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[strA.length][strB.length]);
        getText(strA.length, strB.length);
        System.out.println(sb.reverse());
    }

    public static void getText(int row, int col) {
        if (row == 0 || col == 0) {
            return;
        }
        if (strA[row-1] == strB[col-1]) {
            sb.append(strA[row-1]);
            getText(row-1, col-1);
        } else {
            if (dp[row-1][col] > dp[row][col-1]) {
                getText(row-1, col);
            } else {
                getText(row, col-1);
            }
        }
    }
}
