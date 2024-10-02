package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1813 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] count = new int[51];
        for (int i = 0; i < n; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            count[cnt]++;
        }

        int answer = -1;
        for (int i = n; i >= 0; i--) {
            if (count[i] == i) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
