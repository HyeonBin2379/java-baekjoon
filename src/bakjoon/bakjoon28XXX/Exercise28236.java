package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise28236 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = k;
        int minTime = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int time = f-1+m+1-d;
            if (minTime > time) {
                minTime = time;
                answer = i;
            } else if (minTime == time) {
                answer = Math.min(i, answer);
            }
        }
        System.out.println(answer);
    }
}
