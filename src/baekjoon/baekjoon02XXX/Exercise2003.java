package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[len+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
        }

        int start_idx = 0, end_idx = 0;
        int count = 0, sum = 0;
        while (true) {
            if (sum >= num) {
                start_idx++;
                sum = prefixSum[end_idx] - prefixSum[start_idx];
            }
            else if (end_idx == len) {
                break;
            }
            else {
                end_idx++;
                sum = prefixSum[end_idx] - prefixSum[start_idx];
            }

            if (sum == num) {
                count++;
            }
        }

        System.out.println(count);
        br.close();
    }
}
