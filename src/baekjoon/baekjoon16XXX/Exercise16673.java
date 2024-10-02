package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise16673 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());
        long p = Integer.parseInt(st.nextToken());

        long sum = 0;
        for (int i = 1; i <= c; i++) {
            sum += k*i + p*i*i;
        }
        System.out.println(sum);
    }
}
