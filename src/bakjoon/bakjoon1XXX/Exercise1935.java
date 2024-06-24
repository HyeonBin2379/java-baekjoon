package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exercise1935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] exp = br.readLine().toCharArray();

        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for (char c : exp) {
            if (c >= 'A' && c <= 'Z') {
                stack.add((double) num[c - 'A']);
                continue;
            }
            double y = stack.pop();
            double x = stack.pop();
            switch (c) {
                case '+' -> stack.push(x + y);
                case '-' -> stack.push(x - y);
                case '*' -> stack.push(x * y);
                case '/' -> stack.push(x / y);
            }
        }
        System.out.printf("%.2f\n", stack.pop());
    }
}
