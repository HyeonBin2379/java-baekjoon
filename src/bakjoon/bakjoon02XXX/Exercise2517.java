package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2517 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] now = new int[Math.max(n, m)];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            now[i] = Integer.parseInt(st.nextToken());
        }

        int[] past = new int[Math.max(n, m)];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            past[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < Math.max(n, m); i++) {
            if (past[i] > now[i]) {
                max = Math.max(Math.abs(past[i]-now[i]), max);
            }
        }
        System.out.println(max);
    }
}
