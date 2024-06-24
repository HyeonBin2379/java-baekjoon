package bakjoon.bakjoon09XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise9773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int[] num = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            int sum = Arrays.stream(num).sum();
            int mul = 0;
            for (int j = 10; j < 13; j++) {
                mul += num[j]*(int)Math.pow(10, 12-j);
            }
            mul *= 10;
            if (mul+sum >= 10000) {
                System.out.printf("%04d\n", (mul+sum) % 10000);
            } else if (mul+sum < 1000) {
                System.out.println(mul+sum+1000);
            } else {
                System.out.printf("%04d\n", mul+sum);
            }
        }
    }
}
