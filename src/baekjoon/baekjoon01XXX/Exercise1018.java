package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1018 {

    private static char[][] chess;
    private static final char[][] ans1 = new char[8][8];
    private static final char[][] ans2 = new char[8][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        makeAns();
        chess = new char[n][m];
        for (int i = 0; i < n; i++) {
            chess[i] = br.readLine().toCharArray();
        }

        int answer = 32;
        for (int i = 0; i+7 < n; i++) {
            for (int j = 0; j+7 < m; j++) {
                int val1 = changeFirstToWhite(ans1, i, j);
                int val2 = changeFirstToWhite(ans2, i, j);
                answer = Math.min(answer, Math.min(val1, val2));
            }
        }
        System.out.println(answer);
    }

    private static void makeAns() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ans1[i][j] = (i + j) % 2 == 0 ? 'B' : 'W';
                ans2[i][j] = (i + j) % 2 == 0 ? 'W' : 'B';
            }
        }
    }

    private static int changeFirstToWhite(char[][] ans, int sRow, int sCol) {
        int count = 0;
        for (int i = sRow; i < sRow+8; i++) {
            for (int j = sCol; j < sCol+8; j++) {
                count += (chess[i][j] != ans[i-sRow][j-sCol]) ? 1 : 0;
            }
        }
        return count;
    }
}
