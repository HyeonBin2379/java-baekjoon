package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise23827 {
    private static final int DIV = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] original = new long[n+1];
        long[] prefixSum = new long[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < original.length; i++) {
            original[i] = Long.parseLong(st.nextToken());
            prefixSum[i] = ((prefixSum[i-1] % DIV) + (original[i] % DIV)) % DIV;
        }

        long answer = 0L;
        for (int i = 1; i < original.length; i++) {
            answer += original[i] * prefixSum[i-1];
            answer %= DIV;
        }
        System.out.println(answer);
        br.close();
    }
}
