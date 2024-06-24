package bakjoon.bakjoon02XXX;

import java.util.Scanner;
import java.util.Stack;

public class Exercise2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] PS = sc.nextLine().toCharArray();
        System.out.println(getValidPSScore(PS));
    }

    public static int getValidPSScore(char[] PS) {
        Stack<Character> stack = new Stack<>();
        int score = 0;
        int multiple = 1;
        for (int i = 0; i < PS.length; i++) {
            switch (PS[i]) {
                case '(' -> {
                    multiple *= 2;
                    stack.push(PS[i]);
                }
                case '[' -> {
                    multiple *= 3;
                    stack.push(PS[i]);
                }
                case ')' -> {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return 0;
                    }
                    if (PS[i - 1] == '(') {
                        score += multiple;
                    }
                    stack.pop();
                    multiple /= 2;
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return 0;
                    }
                    if (PS[i - 1] == '[') {
                        score += multiple;
                    }
                    stack.pop();
                    multiple /= 3;
                }
            }
        }
        return (stack.isEmpty()) ? score : 0;
    }
}
