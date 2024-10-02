package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Exercise24818 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] section = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] prefixSum = new long[n+1];
        IntStream.rangeClosed(1, n).forEach(i -> prefixSum[i] = prefixSum[i-1]+section[i-1]);

        long total = prefixSum[n];
        if (total % 3 != 0) {
            System.out.println(-1);
            return;
        }

        List<Integer> answer = new ArrayList<>();
        int lastIdx = 0;
        for (int i = 1; i < n; i++) {
            long pSum = prefixSum[i]-prefixSum[lastIdx];
            if (pSum == total/3) {
                answer.add(i);
                lastIdx = i;
            }
        }
        System.out.println(answer.size() < 2 ? -1 : answer.get(0) + " " + answer.get(1));
    }
}
