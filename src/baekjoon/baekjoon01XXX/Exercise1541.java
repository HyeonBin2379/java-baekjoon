package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split("-");
        br.close();
        int result = 0;
        for (int i = 0; i < tokens.length; i++) {
            int temp = mySum(tokens[i]);
            if (i == 0) {
                result += temp;
            } else {
                result -= temp;
            }
        }
        System.out.println(result);
    }

    public static int mySum(String token) {
        int[] numbers = Arrays.stream(token.split("\\+")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(numbers).sum();
    }
}
