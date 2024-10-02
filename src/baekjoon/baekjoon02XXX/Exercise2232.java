package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2232 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] mine = new int[n];
        for (int i = 0; i < n; i++) {
            mine[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (mine[i] >= mine[i+1]) {
                    System.out.println(i+1);
                }
                continue;
            }
            if (i == n-1) {
                if (mine[i] >= mine[i-1]) {
                    System.out.println(i+1);
                }
                continue;
            }

            if (mine[i-1] <= mine[i] && mine[i] >= mine[i+1]) {
                System.out.println(i + 1);
            }
        }
    }
}
