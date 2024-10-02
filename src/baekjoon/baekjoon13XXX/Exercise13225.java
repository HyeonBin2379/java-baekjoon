package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise13225 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());
            int count = 0;
            for (int j = 1; j*j <= num; j++) {
                if (num % j == 0) {
                    count++;
                    if (j != num/j) {
                        count++;
                    }
                }
            }
            sb.append(String.format("%d %d\n", num, count));
        }
        System.out.print(sb);
    }
}
