package bakjoon.bakjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise11161 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int m = Integer.parseInt(br.readLine());
            int now = 0;
            int answer = 0;
            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int in = Integer.parseInt(st.nextToken());
                int out = Integer.parseInt(st.nextToken());
                now += (in - out);
                answer = Math.min(answer, now);
            }
            System.out.println(Math.abs(answer));
        }
    }
}
