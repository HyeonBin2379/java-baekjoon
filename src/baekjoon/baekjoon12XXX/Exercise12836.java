package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Exercise12836 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long[] accountBook = new long[n+1];
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int queryType = Integer.parseInt(st.nextToken());
            switch (queryType) {
                case 1 -> {
                    int p = Integer.parseInt(st.nextToken());
                    accountBook[p] += Integer.parseInt(st.nextToken());
                }
                case 2 -> {
                    int start = Integer.parseInt(st.nextToken());
                    int end = Integer.parseInt(st.nextToken());
                    System.out.println(IntStream.rangeClosed(start, end).mapToLong(i -> accountBook[i]).sum());
                }
            }
        }
    }
}
