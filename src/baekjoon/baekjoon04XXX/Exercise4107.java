package baekjoon.baekjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise4107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0 && k == 0) {
                break;
            }
            int[] pattern = Arrays.stream(br.readLine().split(" ", k)).mapToInt(Integer::parseInt).toArray();
            int total = 0;
            int current = n;
            for (int i = 0; i < m; i++) {
                total += current;
                current += pattern[i % k];
            }
            System.out.println(total);
        }
    }
}
