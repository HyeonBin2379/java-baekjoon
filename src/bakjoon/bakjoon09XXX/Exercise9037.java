package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise9037 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] candies = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                candies[i] = Integer.parseInt(st.nextToken());
                if (candies[i] % 2 == 1) {
                    candies[i]++;
                }
            }

            int rounds = 0;
            while (!isAllEqual(candies)) {
                int[] newCandies = Arrays.stream(candies).map(val -> val/2).toArray();
                for (int i = 0; i < n; i++) {
                    candies[i] = newCandies[i] + newCandies[(i + n - 1) % n];
                    if (candies[i] % 2 == 1) {
                        candies[i]++;
                    }
                }
                rounds++;
            }
            System.out.println(rounds);
        }
    }

    private static boolean isAllEqual(int[] candies) {
        return IntStream.rangeClosed(1, candies.length-1)
                .allMatch(i -> candies[i] == candies[0]);
    }
}
