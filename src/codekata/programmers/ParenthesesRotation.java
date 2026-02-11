package codekata.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParenthesesRotation {

    private final Deque<Character> stack = new ArrayDeque<>();
    private char[] letters;


    public int solution(String s) {
        int answer = 0;
        letters = s.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (isCorrect(i, letters.length)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isCorrect(int startIdx, int len) {
        for (int i = startIdx; i < startIdx+len; i++) {
            char letter = letters[i % len];
            switch (letter) {
                case '(':
                case '{':
                case '[':
                    stack.push(letter);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    }
                    stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    }
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "}}}";
        int result = new ParenthesesRotation().solution(s);
        System.out.println(result);
    }
}
