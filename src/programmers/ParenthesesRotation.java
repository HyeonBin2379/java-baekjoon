package programmers;

import java.util.Stack;

class ParenthesesRotationSolution {
    public int solution(String s) {
        int answer = 0;
        String newString = s + s;
        for (int j = 0; j < s.length(); j++) {
            if (isCorrectParentheses(newString.substring(j, j+s.length()))) {
                answer++;
            }
        }
        return answer;
    }

    public boolean isCorrectParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        char[] PS = str.toCharArray();
        for (char p : PS) {
            switch (p) {
                case '(', '[', '{' -> stack.push(p);
                case ')' -> {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    }
                    stack.pop();
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    }
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}

public class ParenthesesRotation {
    public static void main(String[] args) {
        String s = "[](){}";
        System.out.println(new ParenthesesRotationSolution().solution(s));
    }
}
