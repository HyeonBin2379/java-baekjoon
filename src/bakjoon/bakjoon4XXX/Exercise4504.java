package bakjoon.bakjoon4XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            if (num % n == 0) {
                sb.append(String.format("%d is a multiple of %d.\n", num, n));
            } else {
                sb.append(String.format("%d is NOT a multiple of %d.\n", num, n));
            }
        }
        System.out.print(sb);
    }
}
