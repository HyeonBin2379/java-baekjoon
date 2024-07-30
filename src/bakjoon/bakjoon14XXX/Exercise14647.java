package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise14647 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] bingo = new int[n][m];

        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            bingo[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                int num = bingo[i][j];
                while (num > 0) {
                    if (num % 10 == 9) {
                        row[i]++;
                    }
                    num /= 10;
                }
            }
        }
        Arrays.sort(row);

        int[] col = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = bingo[j][i];
                while (num > 0) {
                    if (num % 10 == 9) {
                        col[i]++;
                    }
                    num /= 10;
                }
            }
        }
        Arrays.sort(col);
        System.out.println(Arrays.stream(row).sum() - Math.max(row[n-1], col[m-1]));
    }
}
