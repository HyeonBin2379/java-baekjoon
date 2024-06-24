package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise28239 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            long m = Long.parseLong(br.readLine());
            int start = 0, end = 62;
            while (start <= end) {
                long sum = (1L << start) + (1L << end);
                if (sum == m) {
                    System.out.println(start + " " + end);
                    break;
                } else if (sum > m) {
                    end--;
                } else {
                    start++;
                }
            }
        }
    }
}
