package bakjoon.bakjoon3XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise3060 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] meal = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int answer = 1;
            int feeds = Arrays.stream(meal).sum();
            while (feeds <= n) {
               feeds *= 4;
               answer++;
            }
            System.out.println(answer);
        }
    }
}
