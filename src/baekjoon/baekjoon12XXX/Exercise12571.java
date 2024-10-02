package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise12571 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] line = new int[n][2];
            for (int j = 0; j < n; j++) {
                line[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int count = 0;
            for (int j = 0; j < n; j++) {
                int a = line[j][0];
                int b = line[j][1];

                for (int k = j+1; k < n; k++) {
                    int x = line[k][0];
                    int y = line[k][1];
                    if ((a > x && b < y) || (a < x && b > y)) {
                        count++;
                    }
                }
            }
            sb.append(String.format("Case #%d: %d\n", i, count));
        }
        System.out.print(sb);
    }
}
