package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] cycle = new int[n];
        for (int i = 0; i < n; i++) {
            cycle[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        for (int i = 1; i <= c; i++) {
            for (int j = 0; j < n; j++) {
                if (i % cycle[j] == 0) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
