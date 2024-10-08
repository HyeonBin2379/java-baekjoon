package baekjoon.baekjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise6591 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (n == 0 && k == 0) {
                break;
            }
            long answer = 1L;
            k = Math.min(k, n-k);
            for (int i = 0; i < k; i++) {
                answer *= n-i;
                answer /= i+1;
            }
            System.out.println(answer);
        }
    }
}
