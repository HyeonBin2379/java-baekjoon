package baekjoon.baekjoon16XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise16503 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[3];
        String[] op = new String[2];
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                num[i/2] = Integer.parseInt(st.nextToken());
            } else {
                op[i/2] = st.nextToken();
            }
        }

        int order = calculate(calculate(num[0], num[1], op[0]), num[2], op[1]);
        int reverse = calculate(num[0], calculate(num[1], num[2], op[1]), op[0]);
        System.out.println(Math.min(order, reverse));
        System.out.println(Math.max(order, reverse));
    }

    public static int calculate(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }
}
