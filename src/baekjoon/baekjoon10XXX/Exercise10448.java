package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise10448 {
    private static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sum = new int[45];
        for (int i = 1; i <= 44; i++) {
            sum[i] = sum[i-1] + i;
        }

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int k = Integer.parseInt(br.readLine());
            sb.append(canBeSame(k) ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }

    public static boolean canBeSame(int k) {
        for (int a = 1; a <= 44; a++) {
            for (int b = a; b <= 44; b++) {
                for (int c = b; c <= 44; c++) {
                    if (sum[a] + sum[b] + sum[c] == k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
