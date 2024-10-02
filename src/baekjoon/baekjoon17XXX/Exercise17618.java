package baekjoon.baekjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise17618 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 1; i <= num; i++) {
            String digit = Integer.toString(i);
            int sum = 0;
            for (int j = 0; j < digit.length(); j++) {
                sum += (digit.charAt(j) - '0');
            }
            if (i % sum == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
