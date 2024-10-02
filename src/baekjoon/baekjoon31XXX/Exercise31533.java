package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise31533 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int min = Math.min(m, n);
        int max = Math.max(m, n);
        if (min % a == 0) {
            if (max % a == 0) {
                System.out.println(Math.min(2*min/a, max));
            } else {
                System.out.println(Math.min((double)2*min/a, Math.min(Math.min(min, (double) 2*max/a), max)));
            }
        } else {
            if (max % a == 0) {
                System.out.println(Math.min((double)2*min/a, Math.min(Math.min(min, (double) 2*max/a), max)));
            } else {
                System.out.println((double)2*min/a);
            }
        }
    }
}
