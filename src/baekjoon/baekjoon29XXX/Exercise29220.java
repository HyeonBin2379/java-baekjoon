package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise29220 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        long[] cost = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long sum = Arrays.stream(cost).sum();
        Arrays.sort(cost);
        if (sum - cost[0] < k) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
