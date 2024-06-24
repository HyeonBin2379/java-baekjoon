package bakjoon.bakjoon7XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise7240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int result = 0, prev = 0;

        for (int i = 1; i <= n; i++) {
            int next = Integer.parseInt(br.readLine());
            result = prev + next;
            if (i < n) {
                result -= (result > s) ? 1 : 0;
            }
            prev = result;
        }
        sb.append(result).append("\n");
        System.out.print(sb);
    }
}
