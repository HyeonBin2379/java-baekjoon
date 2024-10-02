package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise25644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.MAX_VALUE;
        long answer = 0;
        for (int i = 0; i < len; i++) {
            long stock = Integer.parseInt(st.nextToken());
            answer = Math.max(answer, stock-min);
            min = Math.min(min, stock);
        }
        System.out.println(answer);
    }
}
