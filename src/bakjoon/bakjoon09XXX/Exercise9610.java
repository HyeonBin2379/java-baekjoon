package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise9610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] grid = new int[5];
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == 0 || y == 0) {
                grid[0]++;
                continue;
            }

            if (x*y > 0) {
                if (x > 0) {
                    grid[1]++;
                } else {
                    grid[3]++;
                }
            } else {
                if (x > 0) {
                    grid[4]++;
                } else {
                    grid[2]++;
                }
            }
        }
        for (int i = 1; i <= 5; i++) {
            if (i != 5) {
                System.out.printf("Q%d: %d\n", i, grid[i % 5]);
            } else {
                System.out.printf("AXIS: %d\n", grid[i % 5]);
            }
        }
    }
}
