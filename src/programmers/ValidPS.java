package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class ValidPSSolution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] PS = s.toCharArray();
        for (Character parenthesis : PS) {
            switch (parenthesis) {
                case '(' -> stack.push(parenthesis);
                case ')' -> {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
public class ValidPS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String PS = br.readLine();
        br.close();

        ValidPSSolution result = new ValidPSSolution();
        System.out.println(result.solution(PS));
    }
}
