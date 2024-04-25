package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise24197 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[m+1];
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <= m; i++) {
            if (i == 0) {
                num[i] = 1;
                continue;
            }
            num[i] = Integer.parseInt(st.nextToken());
            int diff = Math.abs(num[i]-num[i-1]);
            answer += Math.min(n-diff, diff);
        }

        System.out.println(answer);
    }
}
