package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] num = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            num[i] = num[i-1] + Integer.parseInt(st.nextToken());
        }

        int start = 1, end = 1;
        int min = n+1;
        while (end < n+1 && start < n+1) {
            int sum = num[end]-num[start-1];
            if (sum < s) {
                end++;
            } else {
                min = Math.min(end-start+1, min);
                start++;
                end = Math.max(start, end);
            }
        }
        System.out.println(min == n+1 ? 0 : min);
    }
}
