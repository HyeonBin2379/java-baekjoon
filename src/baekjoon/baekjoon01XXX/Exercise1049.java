package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] set = new int[m];
        int[] each = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            set[i] = Integer.parseInt(st.nextToken());
            each[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(set);
        Arrays.sort(each);

        if (set[0] >= each[0]*6) {
            System.out.println(n * each[0]);
        } else {
            if (set[0] >= (n % 6) * each[0]) {
                System.out.println((n / 6) * set[0] + (n % 6) * each[0]);
            } else {
                System.out.println((n / 6) * set[0] + set[0]);
            }
        }
    }
}
