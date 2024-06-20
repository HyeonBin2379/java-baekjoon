package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise20205 {

    private static int[][] input, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        input = new int[n][n];
        for (int i = 0; i < n; i++) {
            input[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        answer = new int[n*k][n*k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                setArray(i*k, j*k, k);
            }
        }

        for (int i = 0; i < n*k; i++) {
            for (int j = 0; j < n*k; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setArray(int startR, int startC, int size) {
        for (int i = startR; i < startR+size; i++) {
            for (int j = startC; j < startC+size; j++) {
                answer[i][j] = input[startR/size][startC/size];
            }
        }
    }
}
