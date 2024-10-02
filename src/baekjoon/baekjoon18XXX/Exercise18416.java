package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise18416 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxLen = 1, currLen = 1;
        for (int i = 1; i < n; i++) {
            if (seq[i] >= seq[i-1]) {
                currLen++;
            } else {
                maxLen = Math.max(currLen, maxLen);
                currLen = 1;
            }
        }
        System.out.println(Math.max(maxLen, currLen));
    }
}
