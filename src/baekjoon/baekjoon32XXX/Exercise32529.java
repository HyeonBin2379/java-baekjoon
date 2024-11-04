package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise32529 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] weight = new int[n];
        int total = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
            total += weight[i];
        }

        if (total < m) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (total-weight[i] < m) {
                System.out.println(i+1);
                break;
            }
            total -= weight[i];
        }
    }
}
