package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise14659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] height = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            int h = height[i];
            for (int j = i+1; j < n; j++) {
                if (h < height[j]) {
                    break;
                }
                count++;
            }
            answer = Math.max(count, answer);
        }
        System.out.println(answer);
    }
}
