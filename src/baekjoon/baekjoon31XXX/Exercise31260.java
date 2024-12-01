package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise31260 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long half = (Long.parseLong(st.nextToken())*100 + Long.parseLong(st.nextToken()))/2;
        long diff = Long.parseLong(br.readLine());

        long min = (half-diff)/2;
        long max = min + diff;

        System.out.printf("%d %d\n", max/100, max%100);
        System.out.printf("%d %d\n", min/100, min%100);
    }
}
