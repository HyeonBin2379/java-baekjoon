package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            long num = Long.parseLong(br.readLine());
            int j;
            for (j = 2; j < 1000000; j++) {
                if (num % j == 0) {
                    System.out.println("NO");
                    break;
                }
            }
            if (j == 1000000) {
                System.out.println("YES");
            }
        }
    }

}
