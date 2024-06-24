package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise25682 {

    private static int n, m, k;
    private static char[][] chess;
    private static int[][] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        chess = new char[n][m];
        for (int i = 0; i < n; i++) {
            chess[i] = br.readLine().toCharArray();
        }

        prefixSum = new int[n+1][m+1];
        System.out.println(Math.min(findMinimal('B'), findMinimal('W')));
    }

    private static void setPrefixSum(char color) {
        int value;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i+j) % 2 == 0) {
                    value = chess[i][j] != color ? 1 : 0;
                } else {
                    value = chess[i][j] == color ? 1 : 0;
                }
                prefixSum[i+1][j+1] = prefixSum[i][j+1] + prefixSum[i+1][j] - prefixSum[i][j] + value;
            }
        }
    }
    private static int findMinimal(char color) {
        int count = k*k+1;
        setPrefixSum(color);
        for (int i = 1; i <= n-k+1; i++) {
            for (int j = 1; j <= m-k+1; j++) {
                int sum = prefixSum[i+k-1][j+k-1] - prefixSum[i+k-1][j-1] - prefixSum[i-1][j+k-1] + prefixSum[i-1][j-1];
                count = Math.min(count, sum);
            }
        }
        return count;
    }
}