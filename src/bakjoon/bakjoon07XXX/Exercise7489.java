package bakjoon.bakjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise7489 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long answer = 1;
            for (int i = 1; i <= n; i++) {
                answer *= i;
                answer %= 1000000000;
                while (answer % 10 == 0) {
                    answer /= 10;
                }
            }
            System.out.println(answer % 10);
        }
    }
}
