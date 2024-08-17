package bakjoon.bakjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise3085 {

    private static int n;
    private static char[][] candyBox;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        candyBox = new char[n][n];
        for (int i = 0; i < n; i++) {
            candyBox[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                if (j+1 < n && candyBox[i][j] != candyBox[i][j+1]) {
                    swap(i, j, i, j+1);
                    answer = Math.max(countMaxCandyCount(), answer);
                    swap(i, j+1, i, j);
                }
                if (j+1 < n && candyBox[j][i] != candyBox[j+1][i]) {
                    swap(j, i, j+1, i);
                    answer = Math.max(countMaxCandyCount(), answer);
                    swap(j+1, i, j, i);
                }
            }
        }
        System.out.println(answer);
    }

    private static int countMaxCandyCount() {
        int maxCount = 1;

        for (int i = 0; i < n; i++) {
            int count = 1;

            for (int j = 1; j < n; j++) {
                count = (candyBox[i][j] == candyBox[i][j-1]) ? count+1 : 1;
                maxCount = Math.max(count, maxCount);
            }

            count = 1;
            for (int j = 1; j < n; j++) {
                count = (candyBox[j][i] == candyBox[j-1][i]) ? count+1 : 1;
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
    private static void swap(int r, int c, int newR, int newC) {
        char temp = candyBox[r][c];
        candyBox[r][c] = candyBox[newR][newC];
        candyBox[newR][newC] = temp;
    }
}
