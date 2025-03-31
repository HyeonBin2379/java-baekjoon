package algorithm.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Exercise2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        Deque<Character> stack = new ArrayDeque<>();
        int answer = 0;
        int multiple = 1;
        for (int i = 0; i < input.length; i++) {
            switch (input[i]) {
                case '(' -> {
                    multiple *= 2;
                    stack.push(input[i]);
                }
                case '[' -> {
                    multiple *= 3;
                    stack.push(input[i]);
                }
                case ')' -> {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        System.out.println(0);
                        return;
                    }
                    if (input[i - 1] == '(') {
                        answer += multiple;
                    }
                    stack.pop();
                    multiple /= 2;
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        System.out.println(0);
                        return;
                    }
                    if (input[i - 1] == '[') {
                        answer += multiple;
                    }
                    stack.pop();
                    multiple /= 3;
                }
            }
        }

        System.out.println(stack.isEmpty() ? answer : 0);
    }
}
