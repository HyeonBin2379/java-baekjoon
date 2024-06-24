package bakjoon.bakjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise14579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[b+1];
        int answer = 1;
        for (int i = 1; i <= b; i++) {
            prefixSum[i] = prefixSum[i-1] + i;
            if (i >= a) {
                answer *= (prefixSum[i] % 14579);
                answer %= 14579;
            }
        }
        System.out.println(answer);
    }
}
