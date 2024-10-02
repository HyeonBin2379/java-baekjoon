package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise32216 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] t = new int[n+1];
        t[0] = Integer.parseInt(st.nextToken());
        int[] d = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int total = 0;
        for (int i = 1; i <= n; i++) {
            if (t[i-1] > k) {
                t[i] = t[i-1]+d[i-1] - Math.abs(t[i-1]-k);
            } else if (t[i-1] < k) {
                t[i] = t[i-1]+d[i-1] + Math.abs(t[i-1]-k);
            } else {
                t[i] = t[i-1]+d[i-1];
            }
            total += Math.abs(t[i]-k);
        }
        System.out.println(total);
    }
}
