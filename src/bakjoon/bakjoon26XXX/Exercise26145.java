package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise26145 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] reward = new long[n+m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            reward[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n+m; j++) {
                long money = Long.parseLong(st.nextToken());
                reward[j] += money;
                reward[i] -= money;
            }
        }
        Arrays.stream(reward).forEach(value -> System.out.print(value + " "));
    }
}
