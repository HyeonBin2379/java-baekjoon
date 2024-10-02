package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int time = 0;
        int pulse = m;
        while (n > 0) {
            if (pulse + t > M && pulse == m) {
                break;
            }

            if (pulse + t <= M) {
                pulse += t;
                n--;
            } else {
                pulse = Math.max(pulse - r, m);
            }
            time++;
        }
        System.out.println(n != 0 ? -1 : time);
    }
}
