package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1731 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] num = new long[n];
        for (int i = 0; i < n; i++) {
            num[i] = Long.parseLong(br.readLine());
        }

        if (num[n-2]*2 == num[n-1]+num[n-3]) {
            System.out.println(num[n-1]*2 - num[n-2]);
        } else {
            System.out.println(num[n-1]*num[n-1] / num[n-2]);
        }
    }
}
