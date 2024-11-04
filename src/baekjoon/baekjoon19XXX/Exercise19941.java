package baekjoon.baekjoon19XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise19941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] input = br.readLine().toCharArray();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (input[i] != 'P') {
                continue;
            }
            for (int j = Math.max(i-k, 0); j <= Math.min(i+k, n-1); j++) {
                if (input[j] == 'H') {
                    input[j] = '-';
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
