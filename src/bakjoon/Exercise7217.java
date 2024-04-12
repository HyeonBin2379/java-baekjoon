package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise7217 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] washing = new boolean[n + 1];
        for (int i = 0; i < k; i++) {
            int holiday = Integer.parseInt(br.readLine());
            washing[holiday] = true;
        }

        int answer = 1;
        washing[1] = true;
        for (int i = 2; i <= n; i++) {
            if (washing[i]) {
                answer++;
            } else if (!washing[i-1]) {
                washing[i] = true;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
