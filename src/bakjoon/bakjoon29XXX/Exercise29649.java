package bakjoon.bakjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise29649 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");

        List<Integer> answer = new ArrayList<>();
        for (int i = 2; i <= 10; i++) {
            if (checkNum(token[0], i) || checkNum(token[2], i)) {
                continue;
            }

            BigInteger num1 = new BigInteger(token[0], i);
            BigInteger num2 = new BigInteger(token[2], i);
            switch (token[1]) {
                case "+" -> num1 = num1.add(num2);
                case "-" -> num1 = num1.subtract(num2);
                case "*" -> num1 = num1.multiply(num2);
            }
            if (num1.toString(i).equals(token[4])) {
                answer.add(i);
            }
        }
        System.out.println(answer.size());
        answer.forEach(base -> System.out.print(base + " "));
    }

    private static boolean checkNum(String token, int base) {
        int[] num = Arrays.stream(token.split("")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(num).anyMatch(value -> value >= base);
    }
}
