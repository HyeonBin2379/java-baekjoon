package baekjoon.baekjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise27326 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] group = new int[n];
        for (int i = 0; i < 2*n-1; i++) {
            int num = Integer.parseInt(st.nextToken());
            group[num-1]++;
        }

        for (int i = 0; i < n; i++) {
            if (group[i] == 1) {
                System.out.println(i+1);
                return;
            }
        }
    }
}
