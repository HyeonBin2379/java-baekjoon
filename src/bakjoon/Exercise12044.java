package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise12044 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            long[][] robots = new long[4][n];
            for (int j = 0; j < 4; j++) {
                robots[j] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            }

            long count = 0;
            for (long a : robots[0]) {
                for (long b : robots[1]) {
                    for (long c : robots[2]) {
                        for (long d : robots[3]) {
                            if ((a ^ b ^ c ^ d) == k) {
                                count++;
                            }
                        }
                    }
                }
            }
            sb.append(String.format("Case #%d: %d\n", i, count));
        }
        System.out.print(sb);
    }
}
