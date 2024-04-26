package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            int score = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                int ans = Integer.parseInt(st.nextToken());
                if (ans == j % 5 + 1) {
                    score++;
                }
            }
            if (score == 10) {
                System.out.println(i);
            }
        }
    }
}
