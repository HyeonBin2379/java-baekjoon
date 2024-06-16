package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise13420 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] token = br.readLine().split(" ");
            long num1 = Long.parseLong(token[0]);
            long num2 = Long.parseLong(token[2]);
            long result = Long.parseLong(token[4]);

            long calculate = switch (token[1]) {
                case "+" -> num1 + num2;
                case "-" -> num1 - num2;
                case "*" -> num1 * num2;
                case "/" -> num1 / num2;
                default -> 0;
            };
            System.out.println(calculate == result ? "correct" : "wrong answer");
        }
    }
}
