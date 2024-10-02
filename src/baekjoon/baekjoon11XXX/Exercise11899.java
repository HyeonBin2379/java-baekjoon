package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exercise11899 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (char p : input) {
            switch (p) {
                case '(' -> stack.push(p);
                case ')' -> {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        answer++;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        answer += stack.isEmpty() ? 0 : stack.size();
        System.out.println(answer);
    }
}
