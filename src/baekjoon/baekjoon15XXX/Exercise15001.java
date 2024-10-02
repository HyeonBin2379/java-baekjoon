package baekjoon.baekjoon15XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise15001 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stop = new int[n];
        long count = 0;
        for (int i = 0; i < n; i++) {
            stop[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < n-1; i++) {
            count += Math.pow(stop[i+1]-stop[i], 2);
        }
        System.out.println(count);
    }
}
