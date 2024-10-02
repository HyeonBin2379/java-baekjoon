package baekjoon.baekjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise23925 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            long s = Long.parseLong(st.nextToken());

            sb.append(String.format("Case #%d: ", i));
            long option1 = k+n;
            long option2 = k + (k-s) + (n-s);
            sb.append(Math.min(option1, option2)).append("\n");
        }
        System.out.print(sb);
    }
}
