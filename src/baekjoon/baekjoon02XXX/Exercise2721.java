package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            long num = Long.parseLong(br.readLine());
            long sum = 0L;
            for (long j = 1; j <= num; j++) {
                sum += j*(j+1)*(j+2)/2;
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
