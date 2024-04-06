package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise29684 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] dist = new int[n];
            int min = Integer.MAX_VALUE, answer = 0;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                dist[i] = Math.abs(num-2023);
                if (min > dist[i]) {
                    min = dist[i];
                    answer = i+1;
                }
            }
            System.out.println(answer);
        }
    }
}
