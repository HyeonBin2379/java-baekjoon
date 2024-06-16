package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Exercise14002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = IntStream.rangeClosed(0, n-1).map(index -> 1).toArray();
        int[] lastPos = IntStream.rangeClosed(0, n-1).map(index -> -1).toArray();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (seq[i] > seq[j] && dp[i] < dp[j]+1) {
                    dp[i] = dp[j] + 1;
                    lastPos[i] = j;
                }
            }
        }

        int maxLen = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLen) {
                maxLen = Math.max(dp[i], maxLen);
                maxIndex = i;
            }
        }

        Deque<String> result = new LinkedList<>();
        while (maxIndex != -1) {
            result.addFirst(Integer.toString(seq[maxIndex]));
            maxIndex = lastPos[maxIndex];
        }

        System.out.println(maxLen);
        System.out.println(String.join(" ", result));
    }
}