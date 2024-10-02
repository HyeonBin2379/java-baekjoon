package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise13684 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int k = Integer.parseInt(br.readLine());
            if (k == 0) {
                break;
            }
            int[] mid = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (x == mid[0] || y == mid[1]) {
                    sb.append("divisa").append("\n");
                    continue;
                }

                if (x > mid[0]) {
                    sb.append(y > mid[1] ? "NE" : "SE").append("\n");
                } else {
                    sb.append(y > mid[1] ? "NO" : "SO").append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
